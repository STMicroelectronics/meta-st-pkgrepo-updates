SUMMARY = "The IxNetwork Python Client"

HOMEPAGE = "https://github.com/OpenIxia/ixnetwork_restpy"
SECTION = "devel/python"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fcee478b8b4b2e8603a64208ad930ae1"

SRC_URI[sha256sum] = "cc10905fe7c921b54a2b1a5684dcf16855bfce540544e7ce2686030acf098837"

PYPI_PACKAGE = "ixnetwork_restpy"

inherit pypi python_hatchling

RDEPENDS:${PN} = " \
    python3-requests \
    python3-websocket-client \
"
