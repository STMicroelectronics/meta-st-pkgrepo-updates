# Copyright (C) 2023, STMicroelectronics - All Rights Reserved
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMMARY = "Package Group from the updates Component"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup python3-dir

RDEPENDS:${PN} = " \
    hplip \
    libpqxx \
    openvpn-install \
    ${PYTHON_PN}-azure-identity \
    ${PYTHON_PN}-azure-servicebus \
    ${PYTHON_PN}-azure-storage-blob \
    ${PYTHON_PN}-ixnetwork-restpy \
    qtbase \
    samba \
"
