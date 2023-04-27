SUMMARY = "Microsoft Authentication Extensions for Python"
DESCRIPTION = "Microsoft Authentication Library extensions (MSAL EX) provides \
a persistence API that can save your data on disk, encrypted on Windows, macOS \
and Linux. Concurrent data access will be coordinated by a file lock mechanism."
HOMEPAGE = "https://github.com/AzureAD/microsoft-authentication-extensions-for-python"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=27e94c0280987ab296b0b8dd02ab9fe5"
SRC_URI[sha256sum] = "6ab357867062db7b253d0bd2df6d411c7891a0ee7308d54d1e4317c1d1c54252"

RDEPENDS:${PN} = " \
    python3-msal \
    python3-packaging \
    python3-portalocker \
"
