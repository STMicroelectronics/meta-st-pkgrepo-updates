SUMMARY = "Azure Storage Blobs client library for Python"
DESCRIPTION = "Azure Blob storage is Microsoft's object storage solution for \
the cloud. Blob storage is optimized for storing massive amounts of \
unstructured data, such as text or binary data."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/storage/azure-storage-blob"

# Change the package name ('_' instead of '-')
PYPI_PACKAGE = "azure_storage_blob"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02"
SRC_URI[sha256sum] = "42364ca8f9f49dbccd0acc10144ed47bb6770bf78719970b51915f048891abba"

RDEPENDS:${PN} = " \
    python3-azure-core \
    python3-cryptography \
    python3-isodate \
    python3-typing-extensions \
"
