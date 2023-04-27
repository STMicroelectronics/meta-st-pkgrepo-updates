SUMMARY = "Python AMQP low-level client library"
DESCRIPTION = "This is a fork of amqplib which was originally written \
by Barry Pederson. It is maintained by the Celery project, and used by \
kombu as a pure python alternative when librabbitmq is not available. \
\
This library should be API compatible with librabbitmq."
HOMEPAGE = "https://github.com/celery/py-amqp/"

inherit pypi setuptools3

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9d6ba772ac59c08a25a12ce15bd5f27b"
SRC_URI[sha256sum] = "a1ecff425ad063ad42a486c902807d1482311481c8ad95a72694b2975e75f7fd"

RDEPENDS:${PN} = " \
    python3-vine \
"
