# Updated from https://github.com/meta-qt5/meta-qt5/pull/525

SUMMARY = "Sip module support for PyQt5"
DESCRIPTION = "The sip extension module provides support for the \
PyQt5 package"
AUTHOR = "Phil Thomson @ riverbank.co.uk"
HOMEPAGE = "https://www.riverbankcomputing.com/software/sip"
SECTION = "devel/python"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9cd437778ebd1c056a76b4ded73b3a6d"

PYPI_PACKAGE = "PyQt5_sip"

inherit pypi setuptools3

SRC_URI[sha256sum] = "8fdc6e0148abd12d977a1d3828e7b79aae958e83c6cb5adae614916d888a6b10"
