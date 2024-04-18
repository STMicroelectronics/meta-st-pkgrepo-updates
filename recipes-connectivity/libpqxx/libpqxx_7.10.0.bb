SUMMARY = "Official C++ client API for PostgreSQL"
DESCRIPTION = "libpqxx is a C++ API to the PostgreSQL database management system."
HOMEPAGE = "http://pqxx.org/development/libpqxx/"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=633f766a9675754e2fb785b447df307b"

SRC_URI = "git://github.com/jtv/libpqxx.git;protocol=https;branch=master"
SRCREV = "d280c6c9a6d063638b5bb0d2450bc15ed641c27c"

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
