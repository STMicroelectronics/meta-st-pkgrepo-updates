SUMMARY = "The IxNetwork Python Client"

HOMEPAGE = "https://github.com/OpenIxia/ixnetwork_restpy"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fcee478b8b4b2e8603a64208ad930ae1"

SRC_URI[sha256sum] = "9d3625e7b95881e234a6593dfd89bcd56004c3c5c122fefd11734483e17e1edd"

PYPI_PACKAGE = "ixnetwork_restpy"

inherit pypi setuptools3

RDEPENDS:${PN} = " \
    python3-requests \
    python3-websocket-client \
"
