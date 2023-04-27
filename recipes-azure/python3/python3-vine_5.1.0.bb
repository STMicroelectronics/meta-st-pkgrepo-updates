SUMMARY = "vine - Python Promises"
DESCRIPTION = "This is a special implementation of promises in that \
it can be used both for promise of a value and lazy evaluation. The \
biggest upside for this is that everything in a promise can also be \
a promise, e.g. filters, callbacks and errbacks can all be promises."
HOMEPAGE = "https://github.com/celery/vine"

inherit pypi setuptools3

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6fadb0e48ceb84b571372dd706ed76a0"
SRC_URI[sha256sum] = "8b62e981d35c41049211cf62a0a1242d8c1ee9bd15bb196ce38aefd6799e61e0"
