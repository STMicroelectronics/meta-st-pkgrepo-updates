SUMMARY = "A dynamic image editor, image viewer, 1D/2D Barcode Generator and 1D/2D Barcode Decoder nodes"
DESCRIPTION = "Node-Red image tools node"
HOMEPAGE = "https://flows.nodered.org/node/node-red-contrib-image-tools"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e28de063845e253cd2359c15caeb1340"

SRC_URI = " \
    npm://registry.npmjs.org/;package=node-red-contrib-image-tools;version=${PV} \
    npmsw://${THISDIR}/${BPN}/npm-shrinkwrap.json \
"

S = "${WORKDIR}/npm"

inherit npm
