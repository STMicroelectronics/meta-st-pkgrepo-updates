PV = "2.1.3"

SRCREV = "42ea7cd48d2b3c306d59bb6c530d79f8c25bf9f5"
SRC_URI = "git://git.infradead.org/mtd-utils.git \
           file://add-exclusion-to-mkfs-jffs2-git-2.patch \
           "

# configuration from 2.1.1 no longer in 2.1.3
EXTRA_OECONF_remove += "--enable-install-tests"
