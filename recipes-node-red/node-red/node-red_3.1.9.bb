SUMMARY = "Low-code programming for event-driven applications"
DESCRIPTION = "Node-RED"
HOMEPAGE = "https://nodered.org"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=014f1a23c3da49aa929b21a96808ab22"

SRC_URI = " \
    npm://registry.npmjs.org/;package=node-red;version=${PV} \
    npmsw://${THISDIR}/${BPN}/npm-shrinkwrap.json \
    file://${BPN}.service \
"

S = "${WORKDIR}/npm"

inherit npm systemd

inherit npm systemd

do_install:append() {
    # Service
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/${BPN}.service ${D}${systemd_unitdir}/system/

    # Remove tmp files
    rm -rf ${D}/${libdir}/node_modules/${BPN}/node_modules/bcrypt/build-tmp-napi-v3
    rm -rf ${D}/${libdir}/node_modules/${BPN}/node_modules/node-red-admin/node_modules/bcrypt/build-tmp-napi-v3

    # Remove unecessary files that trigger warning messages
    rm -rf ${D}/${libdir}/node_modules/${BPN}/node_modules/bcrypt/node-addon-api/nothing.target.mk
    rm -rf ${D}/${libdir}/node_modules/${BPN}/node_modules/node-red-admin/node-addon-api/nothing.target.mk
}

SYSTEMD_AUTO_ENABLE:${PN} = "enable"
SYSTEMD_SERVICE:${PN} = "${BPN}.service"

FILES:${PN} += "\
    ${systemd_unitdir}/system/${BPN}.service \
"

INSANE_SKIP:${PN} += "staticdev"
