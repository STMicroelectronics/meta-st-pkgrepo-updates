SUMMARY = "An evaluation context for Rust"
DESCRIPTION = "Common library shared by the evcxr-Jupyter crate, may be useful for other purposes."
HOMEPAGE = "https://github.com/evcxr/evcxr"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = " \
    file://evcxr/LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57 \
"

SRC_URI = "git://github.com/evcxr/evcxr;protocol=https;nobranch=1"
SRCREV = "e6deec6060bc47297eb90674cca496c6874f99ba"

S = "${WORKDIR}/git"
CARGO_SRC_DIR = "evcxr"

inherit cargo cargo-update-recipe-crates

require ${BPN}-crates.inc
