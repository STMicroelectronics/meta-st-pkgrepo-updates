SUMMARY = "Microsoft Azure Identity Library for Python"
DESCRIPTION = "The Azure Identity library provides Azure Active Directory \
(Azure AD) token authentication support across the Azure SDK."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/identity/azure-identity"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02"
SRC_URI[sha256sum] = "32ecc67cc73f4bd0595e4f64b1ca65cd05186f4fe6f98ed2ae9f1aa32646efea"

RDEPENDS:${PN} = " \
    python3-azure-core \
    python3-cryptography \
    python3-msal \
    python3-msal-extensions \
"
