SUMMARY = "The IxNetwork Python Client"

HOMEPAGE = "https://github.com/OpenIxia/ixnetwork_restpy"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fcee478b8b4b2e8603a64208ad930ae1"

SRC_URI[sha256sum] = "a407fbf6877cb2a823aede92e52738e67962633cc5523cf1596853a76602ef75"

PYPI_PACKAGE = "ixnetwork_restpy"

inherit pypi setuptools3

RDEPENDS:${PN} = " \
    python3-requests \
    python3-websocket-client \
"
