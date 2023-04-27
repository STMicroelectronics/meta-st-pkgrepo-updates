SUMMARY = "Azure Storage Blobs client library for Python"
DESCRIPTION = "Azure Blob storage is Microsoft's object storage solution for \
the cloud. Blob storage is optimized for storing massive amounts of \
unstructured data, such as text or binary data."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/storage/azure-storage-blob"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02"
SRC_URI[sha256sum] = "b3804bb4fe8ab1c32771fa464053da772a682c2737b19da438a3f4e5e3b3736e"

RDEPENDS:${PN} = " \
    python3-azure-core \
    python3-cryptography \
    python3-isodate \
    python3-typing-extensions \
"
