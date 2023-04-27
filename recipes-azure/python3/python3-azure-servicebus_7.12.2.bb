SUMMARY = "Microsoft Azure Service Bus Client Library for Python"
DESCRIPTION = "Azure Service Bus is a high performance cloud-managed \
messaging service for providing real-time and fault-tolerant communication \
between distributed senders and receivers."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/servicebus/azure-servicebus"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02"
SRC_URI[sha256sum] = "a6a3c5f79ed5bef101d9e3e3c986a103b200e26c4953c47a52f552c757e45eca"

RDEPENDS:${PN} = " \
    python3-azure-core \
    python3-isodate \
    python3-typing-extensions \
"
