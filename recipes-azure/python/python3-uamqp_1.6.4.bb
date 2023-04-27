SUMMARY = "An AMQP 1.0 client library for Python"
DESCRIPTION = "An AMQP 1.0 client library for Python"
HOMEPAGE = "https://github.com/Azure/azure-uamqp-python/"

inherit cmake setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b98fddd052bb2f5ddbcdbd417ffb26a8"
SRCREV = "5b31ff4fbb824c35320646b912818b2ea9d25239"
SRC_URI = " git://github.com/Azure/azure-uamqp-python.git;protocol=https;branch=main;subdir=${BPN}-${PV}"

DEPENDS += "python3-cython-native"
RDEPENDS_${PN} = "python3-certifi"
