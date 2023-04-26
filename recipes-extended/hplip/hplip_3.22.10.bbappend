# Patch to fix error with Python 3.12
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += " \
    file://Fix-compatibility-with-python3-12.patch \
"

# Missing dependency for hp-setup utility
RDEPENDS:${PN} += " \
    python3-dbus \
"

# disable systemd as dpkg tries to start the template file hplip-printer@.service
SYSTEMD_AUTO_ENABLE:${PN} = "disable"

# remove the prerm function that tries to stop hplip-printer@.service
systemd_prerm() {
}

PR = "r1"
