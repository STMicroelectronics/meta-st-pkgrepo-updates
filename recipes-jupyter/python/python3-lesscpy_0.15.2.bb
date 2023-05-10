# Copyright (C) 2023 cpriouzeau <christophe.priouzeau@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Python lesscpy: Python LESS Compiler"
HOMEPAGE = "https://pypi.python.org/pypi/lesscpy"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a01aae31681ac25b4c46f98d627b9b5d"

DEPENDS += " \
        python3-ply \
"
RDEPENDS:${PN} += " \
        python3-ply \
"

SRC_URI[sha256sum] = "4f6b7f34c22c5ce137e7ee280dcb1984ade0d500b6dab591d4a4d84252d18de9"

inherit pypi python_setuptools_build_meta
