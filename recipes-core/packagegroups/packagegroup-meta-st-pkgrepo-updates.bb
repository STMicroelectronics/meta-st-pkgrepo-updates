# Copyright (C) 2021, STMicroelectronics - All Rights Reserved
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMMARY = "Package Group from the updates Component"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup

RDEPENDS:${PN} = " \
    adwaita-icon-theme \
    hplip \
    libpqxx \
    mtd-utils \
    node-red \
    node-red-contrib-image-tools \
    node-red-dashboard \
    node-red-node-sqlite \
    openvpn-install \
    python3-pip \
    python3-pyqt5 \
    qtbase \
    samba \
    tio \
   "
