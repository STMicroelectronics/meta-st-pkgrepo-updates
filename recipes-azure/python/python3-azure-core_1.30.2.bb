SUMMARY = "Azure Core shared client library for Python"
DESCRIPTION = "Azure core provides shared exceptions and modules for Python \
SDK client libraries."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/core/azure-core"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02"
SRC_URI[sha256sum] = "a14dc210efcd608821aa472d9fb8e8d035d29b68993819147bc290a8ac224472"

RDEPENDS:${PN} = " \
    python3-requests \
    python3-six \
    python3-typing-extensions \
"
