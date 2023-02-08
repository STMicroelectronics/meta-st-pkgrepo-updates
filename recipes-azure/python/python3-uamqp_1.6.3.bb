SUMMARY = "An AMQP 1.0 client library for Python"
DESCRIPTION = "An AMQP 1.0 client library for Python"
HOMEPAGE = "https://github.com/Azure/azure-uamqp-python/"

inherit cmake setuptools3

DEPENDS += "python3-cython-native"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b98fddd052bb2f5ddbcdbd417ffb26a8"

SRCREV = "13ddcbe8784294d485a0a57aed5cca37e463f414"

SRC_URI = " git://github.com/Azure/azure-uamqp-python.git;protocol=https;branch=main;subdir=${BPN}-${PV} "
SRC_URI += " file://0001-add-openssl-3-compat.patch "
