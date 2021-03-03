DESCRIPTION = "Node-Red dashboard node"
HOMEPAGE = "https://github.com/node-red/node-red-dashboard"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=088ce976a5d78ef059391f1ca042eb3d"

inherit npm

SRC_URI = " \
    npm://registry.npmjs.org/;package=node-red-dashboard;version=${PV} \
    npmsw://${THISDIR}/${BPN}/npm-shrinkwrap.json \
    "

S = "${WORKDIR}/npm"
