SUMMARY = "Microsoft Azure Identity Library for Python"
DESCRIPTION = "The Azure Identity library provides Azure Active Directory \
(Azure AD) token authentication support across the Azure SDK."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/identity/azure-identity"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02"
SRC_URI[sha256sum] = "7f9b1ae7d97ea7af3f38dd09305e19ab81a1e16ab66ea186b6579d85c1ca2347"

PYPI_PACKAGE = "azure-identity"
PYPI_PACKAGE_EXT = "zip"

RDEPENDS:${PN} = " \
                  ${PYTHON_PN}-msal \
                 "
