# Bug in the class openembedded-core/meta/classes/gtk-icon-cache.bbclass
GTKIC_CMD = "${@ 'gtk-update-icon-cache-3.0' if d.getVar('GTKIC_VERSION') == '3' else 'gtk4-update-icon-cache' }"

PR = "r1"
