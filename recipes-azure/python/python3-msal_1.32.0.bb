SUMMARY = "Microsoft Authentication Library (MSAL) for Python"
DESCRIPTION = "The Microsoft Authentication Library (MSAL) for Python library \
enables your app to access the Microsoft Cloud by supporting authentication of \
users with Microsoft Azure Active Directory accounts (AAD) and Microsoft \
Accounts (MSA) using industry standard OAuth2 and OpenID Connect."
HOMEPAGE = "https://github.com/AzureAD/microsoft-authentication-library-for-python"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bbfbc44677c93751d972e8b36751a695"
SRC_URI[sha256sum] = "5445fe3af1da6be484991a7ab32eaa82461dc2347de105b76af92c610c3335c2"

RDEPENDS:${PN} = " \
    python3-cryptography \
    python3-pyjwt \
    python3-requests \
"
