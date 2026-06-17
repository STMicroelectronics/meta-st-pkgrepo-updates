SUMMARY = "Azure Core shared client library for Python"
DESCRIPTION = "Azure core provides shared exceptions and modules for Python \
SDK client libraries."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/core/azure-core"

# Change the package name ('_' instead of '-')
PYPI_PACKAGE = "azure_core"

inherit pypi python_setuptools_build_meta

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e848d080178fb2d08b67acc5ba80b9fd"
SRC_URI[sha256sum] = "f46ff5dfcd230f25cf1c19e8a34b8dc08a337b2503e268bb600a16c00db8ad5a"

RDEPENDS:${PN} = " \
    python3-requests \
    python3-six \
    python3-typing-extensions \
"
