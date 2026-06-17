SUMMARY = "Microsoft Azure Identity Library for Python"
DESCRIPTION = "The Azure Identity library provides Azure Active Directory \
(Azure AD) token authentication support across the Azure SDK."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/identity/azure-identity"

# Change the package name ('_' instead of '-')
PYPI_PACKAGE = "azure_identity"

inherit pypi python_setuptools_build_meta

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e848d080178fb2d08b67acc5ba80b9fd"
SRC_URI[sha256sum] = "ab23c0d63015f50b630ef6c6cf395e7262f439ce06e5d07a64e874c724f8d9e6"

RDEPENDS:${PN} = " \
    python3-azure-core \
    python3-cryptography \
    python3-msal \
    python3-msal-extensions \
    python3-typing-extensions \
"
