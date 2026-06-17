SUMMARY = "Microsoft Authentication Extensions for Python"
DESCRIPTION = "Microsoft Authentication Library extensions (MSAL EX) provides \
a persistence API that can save your data on disk, encrypted on Windows, macOS \
and Linux. Concurrent data access will be coordinated by a file lock mechanism."
HOMEPAGE = "https://github.com/AzureAD/microsoft-authentication-extensions-for-python"

# Change the package name ('_' instead of '-')
PYPI_PACKAGE = "msal_extensions"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=27e94c0280987ab296b0b8dd02ab9fe5"
SRC_URI[sha256sum] = "c5b0fd10f65ef62b5f1d62f4251d51cbcaf003fcedae8c91b040a488614be1a4"

RDEPENDS:${PN} = " \
    python3-msal \
    python3-packaging \
    python3-portalocker \
"
