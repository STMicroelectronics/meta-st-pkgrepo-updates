DESCRIPTION = "Python packages to build jupyter notebook with ST addons"

inherit packagegroup python3-dir

RDEPENDS:${PN} = "  \
	packagegroup-python3-jupyter \
	packagegroup-core-buildessential \
	nodejs \
	\
	jupyter-lab-service \
	\
	python3-jupyter-c-kernel \
	python3-jupyterthemes \
"

# Add Rust support for aarch64
RDEPENDS:${PN}:append:aarch64 = " cargo rust rust-llvm rust-llvm-liblto"
