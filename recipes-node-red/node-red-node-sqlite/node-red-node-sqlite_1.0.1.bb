SUMMARY = "A sqlite node for Node-RED"
DESCRIPTION = "A Node-Red node to read and write a local sqlite database"
HOMEPAGE = "https://github.com/node-red/node-red-nodes/tree/master/storage/sqlite"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c0cb74248cfa16e787ab1cf4c16e94e"

SRC_URI = " \
    npm://registry.npmjs.org/;package=node-red-node-sqlite;version=${PV} \
    npmsw://${THISDIR}/${BPN}/npm-shrinkwrap.json \
    "

S = "${WORKDIR}/npm"

inherit npm

RDEPENDS_${PN} += "bash coreutils"

# taken from the openembbed-core/meta/classes/npm.bbclass
# => we replace the line defining pythondir by using python3
python npm_do_compile() {
    import shlex
    import tempfile
    from bb.fetch2.npm import NpmEnvironment

    bb.utils.remove(d.getVar("NPM_BUILD"), recurse=True)

    env = NpmEnvironment(d, configs=npm_global_configs(d))

    dev = bb.utils.to_boolean(d.getVar("NPM_INSTALL_DEV"), False)

    with tempfile.TemporaryDirectory() as tmpdir:
        args = []
        configs = []

        if dev:
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
        sysroot = d.getVar("RECIPE_SYSROOT_NATIVE")
        nodedir = os.path.join(sysroot, d.getVar("prefix_native").strip("/"))
        configs.append(("nodedir", nodedir))
        bindir = os.path.join(sysroot, d.getVar("bindir_native").strip("/"))
        pythondir = os.path.join(bindir, "python3-native", "python3")
        configs.append(("python", pythondir))

        # Add node-pre-gyp configuration
        args.append(("target_arch", d.getVar("NPM_ARCH")))
        args.append(("build-from-source", "true"))

        # Pack and install the main package
        tarball = npm_pack(env, d.getVar("NPM_PACKAGE"), tmpdir)
        env.run("npm install %s" % shlex.quote(tarball), args=args, configs=configs)
}

# remove example using /usr/bin/python and some static libraries
do_install_append() {
    rm -f ${D}${libdir}/node_modules/node-red-node-sqlite/node_modules/node-gyp/gyp/samples/samples

    # this part is inspired from npm.bbclass (in the npm_do_install function)
    local GYP_REGEX=".*/build.*/Release/[^/]*.node"
    for GYP_D_FILE in $(find ${D} -regex "${GYP_REGEX}")
    do
        local GYP_D_DIR=${GYP_D_FILE%/Release/*}

        rm --recursive --force ${GYP_D_DIR}
    done
}

PR = "r1"
