SUMMARY = "AutoRest swagger generator Python client runtime"
DESCRIPTION = "AutoRest swagger generator Python client runtime"
HOMEPAGE = "https://github.com/Azure/msrest-for-python"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI[sha256sum] = "6e7661f46f3afd88b75667b7187a92829924446c7ea1d169be8c4bb7eeb788b9"

PYPI_PACKAGE = "msrest"
PYPI_PACKAGE_EXT = "zip"

RDEPENDS:${PN} = " \
                  ${PYTHON_PN}-isodate \
                  ${PYTHON_PN}-oauthlib \
                  ${PYTHON_PN}-requests-oauthlib \
                 "
