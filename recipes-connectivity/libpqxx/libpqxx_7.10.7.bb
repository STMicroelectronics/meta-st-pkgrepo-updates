SUMMARY = "Official C++ client API for PostgreSQL"
DESCRIPTION = "libpqxx is a C++ API to the PostgreSQL database management system."
HOMEPAGE = "http://pqxx.org/development/libpqxx/"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=23dba67383b24e616ba754c597a6b0dd"

SRC_URI = "git://github.com/jtv/libpqxx.git;protocol=https;branch=7.10"
SRCREV = "853bc0a48f0327d8670c1c0855f7abf731046319"

inherit autotools pkgconfig

DEPENDS = "postgresql autoconf-archive"

EXTRA_OECONF:append = " \
    --disable-documentation \
    --enable-shared \
    --disable-static \
"

INSANE_SKIP:${PN} += "dev-so"

FILES:${PN} = "${libdir}/libpqxx*.so"
FILES:${PN}-dev = "${includedir} ${libdir}/pkgconfig"
