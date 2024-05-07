SUMMARY = "An evaluation context for Rust"
DESCRIPTION = "Common library shared by the evcxr-Jupyter crate, may be useful for other purposes."
HOMEPAGE = "https://github.com/evcxr/evcxr"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = " \
    file://evcxr/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
"

SRC_URI = "git://github.com/evcxr/evcxr;protocol=https;nobranch=1"
SRC_URI += "file://0001-Avoid-embedding-build-host-tool-paths.patch"
SRC_URI += "file://0002-Accept-unhashed-libstd-shared-library.patch"
SRC_URI += "file://0003-Reject-partial-sysroot-metadata.patch;patchdir=${CARGO_VENDORING_DIRECTORY}/ra_ap_project_model-0.0.295"
SRC_URI += "file://0004-Support-kernel-local-toolchain-selection.patch"
SRCREV = "ace31b6c59c8b1280148424c4e3ee72eb5a71b72"

CARGO_SRC_DIR = "evcxr"

inherit cargo cargo-update-recipe-crates

require ${BPN}-crates.inc
