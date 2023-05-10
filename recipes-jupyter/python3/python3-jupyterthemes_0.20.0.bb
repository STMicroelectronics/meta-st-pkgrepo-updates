# Copyright (C) 2023 cpriouzeau <christophe.priouzeau@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

inherit pypi python_setuptools_build_meta

SUMMARY = "JupyterLab Themes:"
HOMEPAGE = "https://github.com/dunovank/jupyter-themes"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d50b2f390d47ce3d90a7b2c362616a55"

# Requirements from PIP:
# jupyter_core, notebook>=5.6.0, ipython>=5.4.1, matplotlib>=1.4.3, lesscpy>=0.11.2

RDEPENDS:${PN} += " \
        ${PYTHON_PN}-jupyter-core \
        ${PYTHON_PN}-notebook \
        ${PYTHON_PN}-ipython \
        ${PYTHON_PN}-matplotlib \
        ${PYTHON_PN}-lesscpy \
"

SRC_URI[sha256sum] = "2a8ebc0c84b212ab99b9f1757fc0582a3f53930d3a75b2492d91a7c8b36ab41e"
