SUMMARY = "An AMQP 1.0 client library for Python"
DESCRIPTION = "An AMQP 1.0 client library for Python"
HOMEPAGE = "https://github.com/Azure/azure-uamqp-python/"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b98fddd052bb2f5ddbcdbd417ffb26a8"
SRC_URI[sha256sum] = "5622e73c4bd3855f852f6fa5842bba8a2ee49b7f715821b1202e2f616d3dcd29"

DEPENDS += "cmake-native"
RDEPENDS_${PN} = " \
    python3-certifi \
"
