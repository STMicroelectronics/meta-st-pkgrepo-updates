SUMMARY = "Azure Core shared client library for Python"
DESCRIPTION = "Azure core provides shared exceptions and modules for Python \
SDK client libraries."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/core/azure-core"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02"
SRC_URI[sha256sum] = "26273a254131f84269e8ea4464f3560c731f29c0c1f69ac99010845f239c1a8f"

RDEPENDS:${PN} = " \
    python3-requests \
    python3-six \
    python3-typing-extensions \
"
