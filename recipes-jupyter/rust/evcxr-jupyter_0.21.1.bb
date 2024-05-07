SUMMARY = "A Jupyter Kernel for Rust"
DESCRIPTION = "A Jupyter Kernel for the Rust programming language."
HOMEPAGE = "https://github.com/evcxr/evcxr"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = " \
    file://evcxr_jupyter/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
"

SRC_URI = "git://github.com/evcxr/evcxr;protocol=https;nobranch=1"
SRC_URI += "file://0001-Avoid-embedding-build-host-tool-paths.patch"
SRC_URI += "file://0002-Accept-unhashed-libstd-shared-library.patch"
SRC_URI += "file://0003-Reject-partial-sysroot-metadata.patch;patchdir=${CARGO_VENDORING_DIRECTORY}/ra_ap_project_model-0.0.295"
SRC_URI += "file://0004-Support-kernel-local-toolchain-selection.patch"
SRC_URI += "file://evcxr-jupyter-launcher"
SRCREV = "ace31b6c59c8b1280148424c4e3ee72eb5a71b72"

CARGO_SRC_DIR = "evcxr_jupyter"

inherit cargo cargo-update-recipe-crates

require ${BPN}-crates.inc

RDEPENDS:${PN} += "evcxr-sysroot cargo"
FILES:${PN} += "${libexecdir}/evcxr"

do_install:append() {
    install -d ${D}${libexecdir}/evcxr
    mv ${D}${bindir}/evcxr_jupyter ${D}${libexecdir}/evcxr/
    sed -e 's|@BINDIR@|${bindir}|g' \
        -e 's|@LIBEXECDIR@|${libexecdir}|g' \
        -e 's|@SYSROOT@|${libdir}/evcxr/sysroot|g' \
        ${UNPACKDIR}/evcxr-jupyter-launcher > ${D}${bindir}/evcxr_jupyter
    chmod 0755 ${D}${bindir}/evcxr_jupyter
}
