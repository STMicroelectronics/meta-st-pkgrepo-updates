SUMMARY = "Azure Core shared client library for Python"
DESCRIPTION = "Azure core provides shared exceptions and modules for Python \
SDK client libraries."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/core/azure-core"

# Change the package name ('_' instead of '-')
PYPI_PACKAGE = "azure_core"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e848d080178fb2d08b67acc5ba80b9fd"
SRC_URI[sha256sum] = "22b3c35d6b2dae14990f6c1be2912bf23ffe50b220e708a28ab1bb92b1c730e5"

RDEPENDS:${PN} = " \
    python3-requests \
    python3-six \
    python3-typing-extensions \
"
