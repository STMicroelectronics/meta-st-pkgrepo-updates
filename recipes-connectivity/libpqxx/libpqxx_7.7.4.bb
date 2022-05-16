SUMMARY = "Official C++ client API for PostgreSQL"
DESCRIPTION = "libpqxx is a C++ API to the PostgreSQL database management system."
HOMEPAGE = "http://pqxx.org/development/libpqxx/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=227be903d79fb9bf45c7d1fe4d7cf0cd"

SRC_URI = "git://github.com/jtv/libpqxx.git;protocol=https;branch=master"
SRCREV = "17e5a6c8ac3abc05329891aaa378bd6004b9c8ee"

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
