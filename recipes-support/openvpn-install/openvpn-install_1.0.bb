SUMMARY = "OpenVPN installer"
DESCRIPTION = "This script will let you setup your own VPN server in just a few seconds."
HOMEPAGE = "https://github.com/angristan/openvpn-install"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=27f2f556b7915490115f1f76122fc39a"

SRCREV = "b2888fa514946edb1aa9803eeb1780b5c90b3bc7"
SRC_URI = "git://github.com/angristan/openvpn-install.git"
SRC_URI[md5sum] = "4e65075de006fd4fb340989ac4309b64"
SRC_URI[sha256sum] = "9c6000341f4252ee361b68c25357e6832683cdf19ff0976bc25b6cbc260057a7"

SRC_URI += "file://0001-openvpn-install-STM.patch"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = "bash openssl-bin openvpn wget curl iptables ca-certificates"

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
