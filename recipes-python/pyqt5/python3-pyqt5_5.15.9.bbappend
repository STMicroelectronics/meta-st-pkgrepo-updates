# Add support for new Python Qt modules
PYQT_MODULES += " \
    QtWebKit \
    QtWebKitWidgets \
    QtPrintSupport \
"

# Update dependencies
DEPENDS:append = "qtwebkit"
RDEPENDS:${PN}:append = "qtwebkit"
