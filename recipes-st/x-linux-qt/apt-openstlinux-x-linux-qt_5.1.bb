# Copyright (C) 2024, STMicroelectronics - All Rights Reserved

SUMMARY = "X-Linux-Qt apt configuration"
DESCRIPTION = "This package updates the apt configuration to access \
X-Linux-Qt packages. \
It also adds a disclaimer licenses file refering to the wiki page."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://10-st-disclaimer-extra-qt \
    file://extra.qt.packages.openstlinux.st.com.list \
"

# The package is target-independant
inherit allarch

S = "${WORKDIR}"

RDEPENDS:${PN} = " \
    apt-openstlinux (>= 5.1-r0) \
    apt-openstlinux (< 5.2) \
"

FILES:${PN} = " \
    ${sysconfdir} \
"

# No need these tasks
do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -d ${D}/${sysconfdir}/apt/sources.list.d
    install -d ${D}/${sysconfdir}/apt/apt.conf.d
    install ${S}/extra.qt.packages.openstlinux.st.com.list ${D}${sysconfdir}/apt/sources.list.d
    install ${S}/10-st-disclaimer-extra-qt  ${D}${sysconfdir}/apt/apt.conf.d
}
