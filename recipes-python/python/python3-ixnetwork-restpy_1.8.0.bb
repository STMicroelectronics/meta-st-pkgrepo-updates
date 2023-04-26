SUMMARY = "The IxNetwork Python Client"

HOMEPAGE = "https://github.com/OpenIxia/ixnetwork_restpy"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fcee478b8b4b2e8603a64208ad930ae1"

SRC_URI[sha256sum] = "fda078e522d48e5b4671b3a66c96cc755825fef608c0d9f98a326d4ec1cf12b7"

PYPI_PACKAGE = "ixnetwork_restpy"

inherit pypi setuptools3

RDEPENDS:${PN} = " \
    python3-requests \
    python3-websocket-client \
"
