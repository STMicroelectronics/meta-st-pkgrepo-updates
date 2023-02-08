SUMMARY = "Azure Storage Blobs client library for Python"
DESCRIPTION = "Azure Blob storage is Microsoft's object storage solution for \
the cloud. Blob storage is optimized for storing massive amounts of \
unstructured data, such as text or binary data."
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/storage/azure-storage-blob"

inherit pypi setuptools3

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02"
SRC_URI[sha256sum] = "860d4d82985a4bfc7d3271e71275af330f54f330a754355435a7ba749ccde997"

PYPI_PACKAGE = "azure-storage-blob"
PYPI_PACKAGE_EXT = "zip"

PR="r1"
