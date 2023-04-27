SUMMARY = "Microsoft Azure Identity Library for Python"
DESCRIPTION = "The Azure Identity library provides Azure Active Directory \
(Azure AD) token authentication support across the Azure SDK."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/identity/azure-identity"

# Change the package name ('_' instead of '-')
PYPI_PACKAGE = "azure_identity"

inherit pypi python_setuptools_build_meta

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e848d080178fb2d08b67acc5ba80b9fd"
SRC_URI[sha256sum] = "6c3a40b2a70af831e920b89e6421e8dcd4af78a0cb38b9642d86c67643d4930c"

RDEPENDS:${PN} = " \
    python3-azure-core \
    python3-cryptography \
    python3-msal \
    python3-msal-extensions \
    python3-typing-extensions \
"
