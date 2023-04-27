SUMMARY = "Microsoft Azure Service Bus Client Library for Python"
DESCRIPTION = "Azure Service Bus is a high performance cloud-managed \
messaging service for providing real-time and fault-tolerant communication \
between distributed senders and receivers."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/servicebus/azure-servicebus"

# Change the package name ('_' instead of '-')
PYPI_PACKAGE = "azure_servicebus"

inherit pypi python_setuptools_build_meta

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02"
SRC_URI[sha256sum] = "4014b7ac882e0d9ff876a3302818607e1a640b93e9d482073d639f5b04266e5c"

RDEPENDS:${PN} = " \
    python3-azure-core \
    python3-isodate \
    python3-typing-extensions \
"
