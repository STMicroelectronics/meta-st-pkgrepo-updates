SUMMARY = "A simple serial device I/O tool"
DESCRIPTION = "tio is a simple serial device tool which features \
a straightforward command-line and configuration file interface \
to easily connect to serial TTY devices for basic I/O operations. \
"
HOMEPAGE = "https://github.com/tio/tio"
AUTHOR = "Martin Lund <martin.lund@keep-it-simple.com>"

SECTION = "console/network"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0e1a95b7892d3015ecd6d0016f601f2c"

PV = "1.46"

SRCREV = "e96d2897180d4191f8ff477d9496961577bd901a"
SRC_URI = "git://github.com/tio/tio.git;branch=master;protocol=https"
SRC_URI[sha256sum] = "5ec3e68e18f956e9998d79088b299fa3bca689bcc95c86001bc5da17c1eb4bd8"

S = "${WORKDIR}/git"

DEPENDS += " \
    libinih \
"

inherit meson pkgconfig
