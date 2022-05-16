# Python 3.10 breaks PEP353
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://add_support_for_py_ssize_t_clean.patch"

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
