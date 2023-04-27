SUMMARY = "Microsoft Azure Service Bus Client Library for Python"
DESCRIPTION = "Azure Service Bus is a high performance cloud-managed \
messaging service for providing real-time and fault-tolerant communication \
between distributed senders and receivers."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/servicebus/azure-servicebus"

# Change the package name ('_' instead of '-')
PYPI_PACKAGE = "azure_servicebus"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02"
SRC_URI[sha256sum] = "a9df6f59c65ee4179237f16b00a96ee16e81cce4e2c82e2616804fe7bc92fb46"

RDEPENDS:${PN} = " \
    python3-azure-core \
    python3-isodate \
    python3-typing-extensions \
"
