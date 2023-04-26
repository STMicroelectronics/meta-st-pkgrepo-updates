SUMMARY = "The IxNetwork Python Client"

HOMEPAGE = "https://github.com/OpenIxia/ixnetwork_restpy"
SECTION = "devel/python"

AUTHOR = "Keysight ISG IxNetwork team"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fcee478b8b4b2e8603a64208ad930ae1"

SRC_URI[sha256sum] = "9dc6750a6abe1e36b1c74ec5436dd3295e8c2bccc6eeaf9250e49cf5f3b9c911"

PYPI_PACKAGE = "ixnetwork_restpy"

inherit pypi setuptools3

RDEPENDS:${PN} = " \
    python3-requests \
    python3-websocket-client \
"
