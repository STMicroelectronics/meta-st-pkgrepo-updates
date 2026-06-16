# Patch to fix error with Python 3.12
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += " \
    file://Fix-compatibility-with-python3-12.patch \
    file://Fix-compatibility-with-python3-14.patch \
"

# Missing dependency for hp-setup utility
RDEPENDS:${PN} += " \
    python3-dbus \
"

PR = "r1"
