# Copyright (C) 2026, STMicroelectronics - All Rights Reserved
#
# Provide matching Rust libraries and sources in a private sysroot for Evcxr,
# avoiding library conflicts without modifying the system Rust toolchain.
#
# This recipe was generated with the assistance of AI.

require recipes-devtools/rust/libstd-rs_1.94.1.bb

FILESEXTRAPATHS:append = ":${COREBASE}/meta/recipes-devtools/rust/files"

SUMMARY = "Private Rust standard library and sources for Evcxr"

SRC_URI += "file://evcxr-rustc"

EVCXR_SYSROOT = "${libdir}/evcxr/sysroot"
rustlibdir = "${EVCXR_SYSROOT}/lib/rustlib/${RUST_HOST_SYS}/lib"

RDEPENDS:${PN} += "rust"
PRIVATE_LIBS:${PN} = "libstd.so"
FILES:${PN} += "${EVCXR_SYSROOT}"
FILES:${PN}-dev = ""
BBCLASSEXTEND = ""

do_install:append() {
    install -d ${D}${EVCXR_SYSROOT}/bin
    sed -e 's|@BINDIR@|${bindir}|g' \
        -e 's|@SYSROOT@|${EVCXR_SYSROOT}|g' \
        ${UNPACKDIR}/evcxr-rustc > ${D}${EVCXR_SYSROOT}/bin/rustc
    chmod 0755 ${D}${EVCXR_SYSROOT}/bin/rustc

    install -m 0644 ${WORKDIR}/rust-targets/${RUST_HOST_SYS}.json \
        ${D}${EVCXR_SYSROOT}/lib/rustlib/${RUST_HOST_SYS}/${RUST_HOST_SYS}.json
    install -m 0644 ${WORKDIR}/rust-targets/${RUST_HOST_SYS}.json \
        ${D}${EVCXR_SYSROOT}/lib/rustlib/${RUST_HOST_SYS}/target.json
    install -d ${D}${EVCXR_SYSROOT}/lib/rustlib/src/rust
    cp -R ${RUSTSRC}/library ${D}${EVCXR_SYSROOT}/lib/rustlib/src/rust/
    find ${D}${EVCXR_SYSROOT}/lib/rustlib/src/rust -name '*.sh' -type f -delete
}