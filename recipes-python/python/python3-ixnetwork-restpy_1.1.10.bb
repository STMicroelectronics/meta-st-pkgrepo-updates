SUMMARY = "The IxNetwork Python Client"

HOMEPAGE = "https://github.com/OpenIxia/ixnetwork_restpy"
SECTION = "devel/python"

AUTHOR = "Keysight ISG IxNetwork team"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fcee478b8b4b2e8603a64208ad930ae1"

SRC_URI[sha256sum] = "76745d38e73529c4e8daf5b28dac645d73314ddaf0add87981e5b1ee1a61fd41"

PYPI_PACKAGE = "ixnetwork_restpy"

inherit pypi setuptools3

RDEPENDS:${PN} = " \
    python3-requests \
    python3-websocket-client \
"
