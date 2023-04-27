SUMMARY = "Microsoft Azure Identity Library for Python"
DESCRIPTION = "The Azure Identity library provides Azure Active Directory \
(Azure AD) token authentication support across the Azure SDK."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/identity/azure-identity"

# Change the package name ('_' instead of '-')
PYPI_PACKAGE = "azure_identity"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e848d080178fb2d08b67acc5ba80b9fd"
SRC_URI[sha256sum] = "ea22ce6e6b0f429bc1b8d9212d5b9f9877bd4c82f1724bfa910760612c07a9a6"

RDEPENDS:${PN} = " \
    python3-azure-core \
    python3-cryptography \
    python3-msal \
    python3-msal-extensions \
    python3-typing-extensions \
"
