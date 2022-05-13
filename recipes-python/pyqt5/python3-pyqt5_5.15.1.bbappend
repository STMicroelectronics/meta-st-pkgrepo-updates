PR = "r1"

# Add support for new Python Qt modules
PYQT_MODULES += "QtWebKit QtWebKitWidgets QtPrintSupport"

# Update dependencies
DEPENDS += "qtwebkit"
RDEPENDS:${PN} += "qtwebkit"
