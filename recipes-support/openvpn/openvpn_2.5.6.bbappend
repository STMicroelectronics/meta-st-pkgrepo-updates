# Rename /var/run into /run to avoid error saying:
# references a path below legacy directory /var/run/

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PR="r1"
