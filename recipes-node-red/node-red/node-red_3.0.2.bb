SUMMARY = "Low-code programming for event-driven applications"
DESCRIPTION = "Node-RED"
HOMEPAGE = "http://nodered.org"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=014f1a23c3da49aa929b21a96808ab22"

SRC_URI = " \
    npm://registry.npmjs.org/;package=${BPN};version=${PV} \
    npmsw://${THISDIR}/${BPN}/npm-shrinkwrap.json \
    file://${BPN}.service \
"

S = "${WORKDIR}/npm"

inherit npm-pkgrepo-updates systemd

do_install:append() {
    # Service
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/${BPN}.service ${D}${systemd_unitdir}/system/
}

SYSTEMD_AUTO_ENABLE:${PN} = "enable"
SYSTEMD_SERVICE:${PN} = "${BPN}.service"

FILES:${PN} += "\
    ${systemd_unitdir}/system/${BPN}.service \
"

INSANE_SKIP:${PN} += "staticdev"
