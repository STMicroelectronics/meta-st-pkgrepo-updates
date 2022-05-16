# disable systemd as dpkg tries to start the template file hplip-printer@.service
SYSTEMD_AUTO_ENABLE:${PN} = "disable"

# remove the prerm function that tries to stop hplip-printer@.service
systemd_prerm() {
}

PR = "r1"
