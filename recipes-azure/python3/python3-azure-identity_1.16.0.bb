SUMMARY = "Microsoft Azure Identity Library for Python"
DESCRIPTION = "The Azure Identity library provides Azure Active Directory \
(Azure AD) token authentication support across the Azure SDK."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/identity/azure-identity"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02"
SRC_URI[sha256sum] = "6ff1d667cdcd81da1ceab42f80a0be63ca846629f518a922f7317a7e3c844e1b"

RDEPENDS:${PN} = " \
    python3-azure-core \
    python3-cryptography \
    python3-msal \
    python3-msal-extensions \
"
