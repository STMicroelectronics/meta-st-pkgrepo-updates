# Copyright (C) 2024, STMicroelectronics - All Rights Reserved
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMMARY = "Package Group from the updates Component"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit packagegroup python3-dir

RDEPENDS:${PN} = " \
    hplip \
    packagegroup-st-jupyter \
    libpqxx \
    openvpn-install \
    python3-ixnetwork-restpy \
    python3-azure-identity \
    python3-azure-servicebus \
    python3-azure-storage-blob \
    python3-msrest \
    python3-amqp \
    python3-uamqp \
    python3-ixnetwork-restpy \
    samba \
"
