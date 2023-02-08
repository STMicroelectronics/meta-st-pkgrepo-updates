SUMMARY = "Microsoft Azure Service Bus Client Library for Python"
DESCRIPTION = "Azure Service Bus is a high performance cloud-managed \
messaging service for providing real-time and fault-tolerant communication \
between distributed senders and receivers."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/servicebus/azure-servicebus"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02"
SRC_URI[sha256sum] = "142e00507595f14c6f0752f3dfffb3fe5fce85d4e3d584a7e222e65edfb3c19a"

PYPI_PACKAGE = "azure-servicebus"
PYPI_PACKAGE_EXT = "zip"

RDEPENDS:${PN} = " \
                  ${PYTHON_PN}-azure-core \
                  ${PYTHON_PN}-msrest \
                  ${PYTHON_PN}-uamqp \
                 "
