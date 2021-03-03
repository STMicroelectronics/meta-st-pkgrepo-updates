PR = "r1"

# Code source from original address is no longer available
SRC_URI = "http://ponce.cc/slackware/sources/repo/PyQt5-${PV}.tar.gz"

# Add support for new Python Qt modules
PYQT_MODULES += "QtWebKit QtWebKitWidgets QtPrintSupport"

# Update dependencies
DEPENDS += "qtwebkit"
RDEPENDS_${PN} += "qtwebkit"
