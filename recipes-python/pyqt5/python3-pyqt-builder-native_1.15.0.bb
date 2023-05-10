# Updated from https://github.com/meta-qt5/meta-qt5/pull/525

SUMMARY = "PEP 517 compliant PyQt build system for PyQt"
DESCRIPTION = "PyQt-builder is the PEP 517 compliant build system \
for PyQt and projects that extend PyQt. It extends the SIP build \
system and uses Qt’s qmake to perform the actual compilation and \
installation of extension modules. \
\
Projects that use PyQt-builder provide an appropriate pyproject.toml \
file and an optional project.py script. Any PEP 517 compliant \
frontend, for example sip-install or pip can then be used to build \
and install the project."
AUTHOR = "Phil Thomson @ riverbank.co.uk"
HOMEPAGE = "https://www.riverbankcomputing.com/software/pyqt-builder"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9cd437778ebd1c056a76b4ded73b3a6d"

PYPI_PACKAGE = "PyQt-builder"

inherit pypi setuptools3 native

SRC_URI[sha256sum] = "a90553703897eb41e27c2f1abd31fb9ed304c32ec3271b380015b54ea9762ddd"
