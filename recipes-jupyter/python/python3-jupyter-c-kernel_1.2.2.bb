# Copyright (C) 2023 cpriouzeau <christophe.priouzeau@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

inherit  python_setuptools_build_meta

SUMMARY = "Minimalistic C kernel for Jupyter"
HOMEPAGE = "https://github.com/brendan-rius/jupyter-c-kernel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2439d431d4a25e0d678df295aade2fbf"

SRC_URI = "git://github.com/brendan-rius/jupyter-c-kernel;protocol=https;branch=master"
SRCREV = "c9a327f77cbf812e638bd78943fec0504e867fab"

S = "${WORKDIR}/git"
