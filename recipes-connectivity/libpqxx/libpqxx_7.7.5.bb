SUMMARY = "Official C++ client API for PostgreSQL"
DESCRIPTION = "libpqxx is a C++ API to the PostgreSQL database management system."
HOMEPAGE = "http://pqxx.org/development/libpqxx/"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=dbbbb9cf256b47a10d70a960a6f6bf39"

SRC_URI = "git://github.com/jtv/libpqxx.git;protocol=https;branch=7.7"
SRCREV = "78e4f95afe0cd4667d0accea83580ae279e0e9d3"

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
