SUMMARY = "Azure Core shared client library for Python"
DESCRIPTION = "Azure core provides shared exceptions and modules for Python \
SDK client libraries."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/core/azure-core"

# Change the package name ('_' instead of '-')
PYPI_PACKAGE = "azure_core"

inherit pypi python_setuptools_build_meta

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e848d080178fb2d08b67acc5ba80b9fd"
SRC_URI[sha256sum] = "22e5605e6d0bf1d229726af56d9e92bc37b6e726b141a18be0b4d424131741b7"

RDEPENDS:${PN} = " \
    python3-requests \
    python3-six \
    python3-typing-extensions \
"
