SUMMARY = "OpenVPN installer"
DESCRIPTION = "This script will let you setup your own VPN server in just a few seconds."
HOMEPAGE = "https://github.com/angristan/openvpn-install"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=27f2f556b7915490115f1f76122fc39a"

SRCREV = "80feebed16b3baa5979f764ee3272443f2fe08e6"
SRC_URI = "git://github.com/angristan/openvpn-install.git;protocol=https;branch=master"

SRC_URI += "file://openvpn-install-STM.patch"

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "bash openssl-bin openvpn wget curl iptables ca-certificates"

# No need these tasks
do_configure[noexec] = "1"
do_compile[noexec] = "1"

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

do_install () {
    install -d ${D}${bindir}
    install -m 0755 openvpn-install.sh ${D}${bindir}
}