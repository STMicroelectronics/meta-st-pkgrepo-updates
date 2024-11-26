SUMMARY = "Startup script and systemd unit file for jupyter lab"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit python3-dir

RDEPENDS:${PN} += " \
    python3-jupyterlab \
    python3-jupyter-server \
    python3-websocket-client \
    python3-requests \
    python3-notebook-shim \
    python3-nbclient \
    python3-jupyterlab-pygments \
    nodejs \
    python3-nest-asyncio \
    python3-argon2-cffi-bindings \
    python3-psutil \
    python3-jupyterlab-widgets \
    python3-pydot \
    python3-pandas \
    python3-ipywidgets \
    python3-charset-normalizer \
    python3-jupyter-c-kernel \
    python3-jupyterthemes \
    python3-rpds-py \
    python3-maturin \
    graphviz \
"

# Add Rust support for aarch64
RDEPENDS:${PN}:append:aarch64 = " evcxr-jupyter evcxr"

SRC_URI = " \
    file://jupyterlab-session.service \
    file://st-jupyter-service.sh \
    \
    file://jupyter_server_config.json \
    file://jupyter_server_config.py \
"

do_install() {
    if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
        install -d ${D}${bindir} ${D}${systemd_system_unitdir}
        install -m 0644 ${WORKDIR}/jupyterlab-session.service ${D}${systemd_system_unitdir}/jupyterlab-session.service
        install -m 0755 ${WORKDIR}/st-jupyter-service.sh ${D}${bindir}/
    fi
    install -o jupyter -g jupyter -d ${D}/home/jupyter/.jupyter
    # note the password are "stm32mp"
    # To generate a new password, as user jupyter type the following command:
    #  > jupyter server password
    install -m 0644 -o jupyter -g jupyter ${WORKDIR}/jupyter_server_config.json ${D}/home/jupyter/.jupyter
    install -m 0644 -o jupyter -g jupyter ${WORKDIR}/jupyter_server_config.py ${D}/home/jupyter/.jupyter
}
FILES:${PN} += "/home/jupyter ${bindir} ${systemd_system_unitdir}"

inherit systemd useradd

USERADD_PACKAGES = "${PN}"

SYSTEMD_SERVICE:${PN} = "jupyterlab-session.service"

#inherit useradd
USERADD_PARAM:${PN} = "--home /home/jupyter --shell /bin/sh --user-group -G video,input,tty,audio,dialout jupyter"
