SUMMARY = "Startup script and systemd unit file for jupyter lab"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit python3-dir

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-jupyterlab \
    ${PYTHON_PN}-jupyter-server \
    ${PYTHON_PN}-websocket-client \
    ${PYTHON_PN}-requests \
    ${PYTHON_PN}-notebook-shim \
    ${PYTHON_PN}-nbclient \
    ${PYTHON_PN}-jupyterlab-pygments \
    nodejs \
    ${PYTHON_PN}-nest-asyncio \
    ${PYTHON_PN}-argon2-cffi-bindings \
    ${PYTHON_PN}-psutil \
    ${PYTHON_PN}-jupyterlab-widgets \
    ${PYTHON_PN}-pydot \
    ${PYTHON_PN}-pandas \
    ${PYTHON_PN}-ipywidgets \
    ${PYTHON_PN}-bokeh \
    ${PYTHON_PN}-charset-normalizer \
    ${PYTHON_PN}-jupyter-c-kernel \
    ${PYTHON_PN}-jupyterthemes \
    graphviz \
"

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
