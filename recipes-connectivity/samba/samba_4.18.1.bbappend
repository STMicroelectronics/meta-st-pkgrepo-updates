# Patch for turning /var/run/samba into /run/samba and avoid warning when instanciating service
SRC_URI:append = "file://Socket-dir-is-no-longer-var-run-samba-but-run-samba.patch"
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"


# Append postinst to create /var/run/samba and /var/log/samba at package installation in samba-common package
pkg_postinst:${BPN}-common:append() {
    if type systemd-tmpfiles > /dev/null 2> /dev/null; then
        systemd-tmpfiles --create
    fi
}

PR = "r1"
