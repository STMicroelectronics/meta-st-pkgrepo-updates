# Copyright (C) 2023 cpriouzeau <christophe.priouzeau@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

inherit pypi python_setuptools_build_meta

SUMMARY = "Python LESS Compiler"
HOMEPAGE = "https://github.com/lesscpy/lesscpy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a01aae31681ac25b4c46f98d627b9b5d"

RDEPENDS:${PN} += " \
        ${PYTHON_PN}-ply \
"

SRC_URI[sha256sum] = "1045d17a98f688646ca758dff254e6e9c03745648e051a081b0395c3b77c824c"
