inherit npm

DEPENDS:prepend = "nodejs-oe-cache-native "

NPM_REGISTRY = "${WORKDIR}/npm-registry"

## 'npm pack' runs 'prepare' and 'prepack' scripts. Support for
## 'ignore-scripts' which prevents this behavior has been removed
## from nodejs 16.  Use simple 'tar' instead of.
def npm_pack(env, srcdir, workdir):
    """Emulate 'npm pack' on a specified directory"""
    import subprocess
    import os
    import json

    src = os.path.join(srcdir, 'package.json')
    with open(src) as f:
        j = json.load(f)

    # base does not really matter and is for documentation purposes
    # only.  But the 'version' part must exist because other parts of
    # the bbclass rely on it.
    base = j['name'].split('/')[-1]
    tarball = os.path.join(workdir, "%s-%s.tgz" % (base, j['version']));

    # TODO: real 'npm pack' does not include directories while 'tar'
    # does.  But this does not seem to matter...
    subprocess.run(['tar', 'czf', tarball,
                    '--exclude', './node-modules',
                    '--exclude-vcs',
                    '--transform', 's,^\./,package/,',
                    '--mtime', '1985-10-26T08:15:00.000Z',
                    '.'],
                   check = True, cwd = srcdir)

    return (tarball, j)

python npm_do_configure() {
    """
    Step one: configure the npm cache and the main npm package

    Every dependencies have been fetched and patched in the source directory.
    They have to be packed (this remove unneeded files) and added to the npm
    cache to be available for the next step.

    The main package and its associated manifest file and shrinkwrap file have
    to be configured to take into account these cached dependencies.
    """
    import base64
    import copy
    import json
    import re
    import shlex
    import tempfile
    from bb.fetch2.npm import NpmEnvironment
    from bb.fetch2.npm import npm_unpack
    from bb.fetch2.npmsw import foreach_dependencies
    from bb.progress import OutOfProgressHandler
    from oe.npm_registry import NpmRegistry

    bb.utils.remove(d.getVar("NPM_CACHE"), recurse=True)
    bb.utils.remove(d.getVar("NPM_PACKAGE"), recurse=True)

    env = NpmEnvironment(d, configs=npm_global_configs(d))
    registry = NpmRegistry(d.getVar('NPM_REGISTRY'), d.getVar('NPM_CACHE'))

    def _npm_cache_add(tarball, pkg):
        """Add tarball to local registry and register it in the
           cache"""
        registry.add_pkg(tarball, pkg)

    def _npm_integrity(tarball):
        """Return the npm integrity of a specified tarball"""
        sha512 = bb.utils.sha512_file(tarball)
        return "sha512-" + base64.b64encode(bytes.fromhex(sha512)).decode()

    def _npmsw_dependency_dict(orig, deptree):
        """
        Return the sub dictionary in the 'orig' dictionary corresponding to the
        'deptree' dependency tree. This function follows the shrinkwrap file
        format.
        """
        ptr = orig
        for dep in deptree:
            if "dependencies" not in ptr:
                ptr["dependencies"] = {}
            ptr = ptr["dependencies"]
            if dep not in ptr:
                ptr[dep] = {}
            ptr = ptr[dep]
        return ptr

    # Manage the manifest file and shrinkwrap files
    orig_manifest_file = d.expand("${S}/package.json")
    orig_shrinkwrap_file = d.expand("${S}/npm-shrinkwrap.json")
    cached_manifest_file = d.expand("${NPM_PACKAGE}/package.json")
    cached_shrinkwrap_file = d.expand("${NPM_PACKAGE}/npm-shrinkwrap.json")

    with open(orig_manifest_file, "r") as f:
        orig_manifest = json.load(f)

    cached_manifest = copy.deepcopy(orig_manifest)
    cached_manifest.pop("dependencies", None)
    cached_manifest.pop("devDependencies", None)

    has_shrinkwrap_file = True

    try:
        with open(orig_shrinkwrap_file, "r") as f:
            orig_shrinkwrap = json.load(f)
    except IOError:
        has_shrinkwrap_file = False

    if has_shrinkwrap_file:
       cached_shrinkwrap = copy.deepcopy(orig_shrinkwrap)
       cached_shrinkwrap.pop("dependencies", None)

    # Manage the dependencies
    progress = OutOfProgressHandler(d, r"^(\d+)/(\d+)$")
    progress_total = 1 # also count the main package
    progress_done = 0

    def _count_dependency(name, params, deptree):
        nonlocal progress_total
        progress_total += 1

    def _cache_dependency(name, params, deptree):
        destsubdirs = [os.path.join("node_modules", dep) for dep in deptree]
        destsuffix = os.path.join(*destsubdirs)
        with tempfile.TemporaryDirectory() as tmpdir:
            # Add the dependency to the npm cache
            destdir = os.path.join(d.getVar("S"), destsuffix)
            (tarball, pkg) = npm_pack(env, destdir, tmpdir)
            _npm_cache_add(tarball, pkg)
            # Add its signature to the cached shrinkwrap
            dep = _npmsw_dependency_dict(cached_shrinkwrap, deptree)
            dep["version"] = pkg['version']
            dep["integrity"] = _npm_integrity(tarball)
            if params.get("dev", False):
                dep["dev"] = True
            # Display progress
            nonlocal progress_done
            progress_done += 1
            progress.write("%d/%d" % (progress_done, progress_total))

    dev = bb.utils.to_boolean(d.getVar("NPM_INSTALL_DEV"), False)

    if has_shrinkwrap_file:
        foreach_dependencies(orig_shrinkwrap, _count_dependency, dev)
        foreach_dependencies(orig_shrinkwrap, _cache_dependency, dev)

    # Configure the main package
    with tempfile.TemporaryDirectory() as tmpdir:
        (tarball, _) = npm_pack(env, d.getVar("S"), tmpdir)
        npm_unpack(tarball, d.getVar("NPM_PACKAGE"), d)

    # Configure the cached manifest file and cached shrinkwrap file
    def _update_manifest(depkey):
        for name in orig_manifest.get(depkey, {}):
            version = cached_shrinkwrap["dependencies"][name]["version"]
            if depkey not in cached_manifest:
                cached_manifest[depkey] = {}
            cached_manifest[depkey][name] = version

    if has_shrinkwrap_file:
        _update_manifest("dependencies")

    if dev:
        if has_shrinkwrap_file:
            _update_manifest("devDependencies")

    with open(cached_manifest_file, "w") as f:
        json.dump(cached_manifest, f, indent=2)

    if has_shrinkwrap_file:
        with open(cached_shrinkwrap_file, "w") as f:
            json.dump(cached_shrinkwrap, f, indent=2)
}

python npm_do_compile() {
    """
    Step two: install the npm package

    Use the configured main package and the cached dependencies to run the
    installation process. The installation is done in a directory which is
    not the destination directory yet.

    A combination of 'npm pack' and 'npm install' is used to ensure that the
    installed files are actual copies instead of symbolic links (which is the
    default npm behavior).
    """
    import shlex
    import tempfile
    from bb.fetch2.npm import NpmEnvironment

    bb.utils.remove(d.getVar("NPM_BUILD"), recurse=True)

    with tempfile.TemporaryDirectory() as tmpdir:
        args = []
        configs = npm_global_configs(d)

        if bb.utils.to_boolean(d.getVar("NPM_INSTALL_DEV"), False):
            configs.append(("also", "development"))
        else:
            configs.append(("only", "production"))

        # Report as many logs as possible for debugging purpose
        configs.append(("loglevel", "silly"))

        # Configure the installation to be done globally in the build directory
        configs.append(("global", "true"))
        configs.append(("prefix", d.getVar("NPM_BUILD")))

        # Add node-gyp configuration
        configs.append(("arch", d.getVar("NPM_ARCH")))
        configs.append(("release", "true"))
        configs.append(("nodedir", d.getVar("NPM_NODEDIR")))
        configs.append(("python", d.getVar("PYTHON")))

        env = NpmEnvironment(d, configs)

        # Add node-pre-gyp configuration
        args.append(("target_arch", d.getVar("NPM_ARCH")))
        args.append(("build-from-source", "true"))

        # Pack and install the main package
        (tarball, _) = npm_pack(env, d.getVar("NPM_PACKAGE"), tmpdir)
        cmd = "npm install %s %s" % (shlex.quote(tarball), d.getVar("EXTRA_OENPM"))
        env.run(cmd, args=args)
}
