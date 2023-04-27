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
SRC_URI[sha256sum] = "96918996642b38c78cd59b55efa0f06fd1373c90e0949be8615697c048fba62c"

RDEPENDS:${PN} = " \
    python3-msal \
    python3-packaging \
    python3-portalocker \
"
