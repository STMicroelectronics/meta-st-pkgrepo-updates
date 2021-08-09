SUMMARY = "Official C++ client API for PostgreSQL"
DESCRIPTION = "libpqxx is a C++ API to the PostgreSQL database management system."
HOMEPAGE = "http://pqxx.org/development/libpqxx/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=3d1b370cdd0dae4a6607aa8e5071e67b"

SRC_URI = "git://github.com/jtv/libpqxx.git;protocol=https;rev=${PV};branch=6.4"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

DEPENDS = "postgresql autoconf-archive"

EXTRA_OECONF_append = " \
    --disable-documentation \
    --with-postgres-include=${STAGING_INCDIR} \
    --enable-shared \
    --disable-static \
   "

INSANE_SKIP_${PN} += "dev-so"

FILES_${PN} = "${libdir}"
FILES_${PN}-dev = "${includedir}"
