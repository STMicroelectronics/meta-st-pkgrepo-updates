SUMMARY = "Low-code programming for event-driven applications"
DESCRIPTION = "Node-RED"
HOMEPAGE = "http://nodered.org"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=014f1a23c3da49aa929b21a96808ab22"

SRC_URI = " \
    git://github.com/node-red/node-red.git;protocol=https;branch=master \
    npmsw://${THISDIR}/${BPN}/npm-shrinkwrap.json \
    file://${BPN}.service \
"
SRCREV = "5f0ea85f47296f32a2f2cf71a99edaf6a6397651"

inherit npm-pkgrepo-updates systemd

S = "${WORKDIR}/git/packages/node_modules/${BPN}"

#EXTRA_OENPM = "--offline=false --proxy=true"

do_install:append() {
    # Service
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/${BPN}.service ${D}${systemd_unitdir}/system/

    # Remove hardware specific files
    rm ${D}/${bindir}/${BPN}-pi
    rm -rf ${D}/${libdir}/node_modules/${BPN}/bin
}

SYSTEMD_AUTO_ENABLE:${PN} = "enable"
SYSTEMD_SERVICE:${PN} = "${BPN}.service"

FILES:${PN} += "\
    ${systemd_unitdir}/system/${BPN}.service \
"

FILES:${PN}-staticdev += "\
    ${libdir}/node_modules/node-red/node_modules/bcrypt/build-tmp-napi-v3/Release/node-addon-api/nothing.a \
    ${libdir}/node_modules/node-red/node_modules/bcrypt/build-tmp-napi-v3/Release/nothing.a \
"
