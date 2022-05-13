SUMMARY = "A sqlite node for Node-RED"
DESCRIPTION = "A Node-Red node to read and write a local sqlite database"
HOMEPAGE = "https://flows.nodered.org/node/node-red-node-sqlite"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c0cb74248cfa16e787ab1cf4c16e94e"

SRC_URI = " \
    npm://registry.npmjs.org/;package=${BPN};version=${PV} \
    npmsw://${THISDIR}/${BPN}/npm-shrinkwrap.json \
    "

S = "${WORKDIR}/npm"

inherit npm-pkgrepo-updates

RDEPENDS:${PN} += "bash coreutils"

# remove examples using /usr/bin/python
do_install:append() {
    rm -f ${D}${libdir}/node_modules/node-red-node-sqlite/node_modules/node-gyp/gyp/samples/samples
}

INSANE_SKIP:${PN} += "staticdev"
