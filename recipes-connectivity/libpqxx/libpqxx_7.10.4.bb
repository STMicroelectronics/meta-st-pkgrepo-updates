SUMMARY = "Official C++ client API for PostgreSQL"
DESCRIPTION = "libpqxx is a C++ API to the PostgreSQL database management system."
HOMEPAGE = "http://pqxx.org/development/libpqxx/"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=23dba67383b24e616ba754c597a6b0dd"

SRC_URI = "git://github.com/jtv/libpqxx.git;protocol=https;branch=master"
SRCREV = "156d1f88d44ccd56c730f44e1d9f05b72f34e62b"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

DEPENDS = "postgresql autoconf-archive"

EXTRA_OECONF:append = " \
    --disable-documentation \
    --with-postgres-include=${STAGING_INCDIR} \
    --enable-shared \
    --disable-static \
"

INSANE_SKIP:${PN} += "dev-so"

FILES:${PN} = "${libdir}"
FILES:${PN}-dev = "${includedir}"
