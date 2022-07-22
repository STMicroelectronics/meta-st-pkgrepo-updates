# meta-st-pkgrepo-updates

## Introduction
The layer meta-st-pkgrepo-updates is used to populate the component 'updates' of the Package Repository Service of OpenSTLinux.

OpenSTLinux is a Linux® distribution based on the OpenEmbedded build framework.

## DISTRO
meta-st-pkgrepo-updates does not provide any distro.

## Images
meta-st-pkgrepo-updates does not provide any images.

meta-st-pkgrepo-updates only provides updates/adds for the Package Repository Service of OpenSTLinux.
Updates are managed through *.bbappend only.
Adds are managed through new recipe *.bb

## How to install and how to use
The OpenEmbedded meta layer meta-st-pkgrepo-updates should be added on top of the STM32MP1 Distribution Package.

1. Install the STM32MP1 Distribution Package but do not initialize the OpenEmbedded environment (i.e. do not source the envsetup.sh script).

2. Clone the meta-st-pkgrepo-updates repository:

  ```
  PC $> cd <Distribution Package installation directory>/layers/meta-st
  PC $> git clone https://github.com/STMicroelectronics/meta-st-pkgrepo-updates.git -b openstlinux-ecosystem-v4.0.0
  ```

3. Setup the environment:

  ```
  PC $> cd ../..
  PC $> DISTRO=openstlinux-weston MACHINE=stm32mp1 BSP_DEPENDENCY='layers/meta-st/meta-st-pkgrepo-updates' source layers/meta-st/scripts/envsetup.sh
  ```

4. Build the package group:

  ```
  PC $> bitbake packagegroup-meta-st-pkgrepo-updates
  ```

5. Activate the local package repository to be accessed from your board on your host PC:

  ```
  PC $> bitbake package-index
  PC $> cd tmp-glibc/deploy/deb
  PC $> python -m SimpleHTTPServer &
  ```

6. Set the local package repository from your board (\<IP\> is the host PC IP):

  ```
  Board $> echo "deb [trusted=yes] http://<IP>:8000/stm32mp1 /" > /etc/apt/sources.list.d/pkgrepo-updates.list
  Board $> echo "deb [trusted=yes] http://<IP>:8000/all /" >> /etc/apt/sources.list.d/pkgrepo-updates.list
  Board $> echo "deb [trusted=yes] http://<IP>:8000/cortexa7t2hf-neon-vfpv4 /" >> /etc/apt/sources.list.d/pkgrepo-updates.list
  Board $> apt-get update
  ```

7. Download packages from the meta-st-pkgrepo-updates layer:

  ```
  Board $> apt-get install <package>
  ```

## List of updated packages in the layer meta-st-pkgrepo-updates
- samba 4.14.13-r1: fix missing directories /var/log/samba and /run/samba at package installation
- hplip 3.19.12-r2: 1/ fix systemd pre and post-installation from template service file, 2/ patch to support migration to Python 3.10
- mtd-utils 2.1.3-r0: upgrade version
- adwaita-icon-them 41.0-r1: fix package pre and post-installation steps
- python3-pyqt5 5.13.2-r1: add support for QtWebKit
- qtbase 5.15.3+git0+c95f96550f-r1: fix compatibility problem between Qt 5.15.3 and OpenSSL 3.0.x
- python3-pip 22.0.3-r1: add missing dependencies

## List of added packages in the layer meta-st-pkgrepo-updates
- openvpn-install 1.0-r0: ease OpenVPN server installation
- libpqxx 7.7.3-r0: provide C++ PostgreSQL connector
- node-red 2.2.2-r0: add support for Node-RED programming
- node-red-dasboard 3.1.7-r0: add a set of dashboard nodes for Node-RED
- node-red-contrib-image-tools 2.0.4-r0: add a dynamic image editor, image viewer, 1D/2D Barcode Generator and 1D/2D Barcode Decoder nodes for Node-RED
- node-red-node-sqlite 1.0.3-r0: add a sqlite node for Node-RED
- tio 1.46-r0: provide simple serial device I/O tool

## Maintainers
- Jean-Marc Bouche <jean-marc.bouche@st.com>
