# meta-st-pkgrepo-updates

## Introduction
The layer meta-st-pkgrepo-updates is used to populate the component 'updates' of the Package Repository Service of OpenSTLinux.

OpenSTLinux is a Linux� distribution based on the OpenEmbedded build framework.

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
  PC $> git clone https://github.com/STMicroelectronics/meta-st-pkgrepo-updates.git -b <branch>
  ```

where <branch> corresponds to the STM32MP1 Distribution Package version.

3. Clone the meta-jupyter repository:

  ```
  PC $> cd <Distribution Package installation directory>/layers
  PC $> git clone https://github.com/Xilinx/meta-jupyter.git -b langdale
  PC $> sed -i 's/langdale/langdale mickledore/' meta-jupyter/conf/layer.conf
  ```

4. Setup the environment:

  ```
  PC $> cd ../..
  PC $> DISTRO=openstlinux-weston MACHINE=stm32mp1 BSP_DEPENDENCY='layers/meta-st/meta-st-pkgrepo-updates layers/meta-jupyter' source layers/meta-st/scripts/envsetup.sh
  ```

5. Build the package group:

  ```
  PC $> bitbake packagegroup-meta-st-pkgrepo-updates
  ```

6. Activate the local package repository to be accessed from your board on your host PC:

  ```
  PC $> bitbake package-index
  PC $> cd tmp-glibc/deploy/deb
  PC $> python -m SimpleHTTPServer &
  ```

7. Set the local package repository from your board (\<IP\> is the host PC IP):

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
- hplip 3.22.10-r1: fix systemd pre and post-installation from template service file and add missing dependency to python3-dbus
- samba 4.18.1-r1: fix missing directories /var/log/samba and /run/samba at package installation

## List of added packages in the layer meta-st-pkgrepo-updates
- apt-openstlinux-x-linux-ai 5.1.0-r0: apt configuration for x-linux-ai packages
- apt-openstlinux-x-linux-aws 5.1.0-r0: apt configuration for x-linux-aws packages
- apt-openstlinux-x-linux-azure 5.1.0-r0: apt configuration for x-linux-azure packages
- apt-openstlinux-x-linux-isp 5.1.0-r0: apt configuration for x-linux-isp packages
- apt-openstlinux-x-linux-qt 5.1.0-r0: apt configuration for x-linux-qt packages
- evcxr 0.15.1-r0: provide an evaluation context for Rust
- evcxr-jupyter 0.15.1-r0: provide a Jupyter kernel for Rust
- libpqxx 7.9.0-r0: provide C++ PostgreSQL connector
- node-red 3.1.9-r0: add support for Node-RED programming
- node-red-dasboard 3.6.5-r0: add a set of dashboard nodes for Node-RED
- node-red-contrib-image-tools 2.1.1-r0: add a dynamic image editor, image viewer, 1D/2D Barcode Generator and 1D/2D Barcode Decoder nodes for Node-RED
- node-red-node-sqlite 1.1.0-r0: add a sqlite node for Node-RED
- openvpn-install 1.0-r0: ease OpenVPN server installation
- python3-amqp 5.2.0-r0: AMQP Client library
- python3-azure-core 1.30.1-r0: provide Azure core shared client library
- python3-azure-identity 1.16.0-r0: Azure identity library
- python3-azure-servicebus 7.12.2-r0: Azure service bus client library
- python3-azure-storage-blob 12.20.0-r0: Azure storage blobs client library
- python3-ixnetwork-restpy 1.3.0-r0: IxNetwork REST API client
- python3-msal 1.28.0-r0: Microsoft authentication library
- python3-msal-extensions 1.1.0-r0: Microsoft authentication library extensions
- python3-msrest 0.7.1-r0: AutoRest swagger generator client runtime
- python3-pyjwt 2.8.0-r0: JSON Web Token implementation in Python
- python3-uamqp 1.6.9-r0: AMQP 1.0 client library
- python3-vine 5.1.0-r0: Python Promises
- jupyter-lab-service 1.0-r0: provide Jupyter lab service
- python3-jupyter-c-kernel 1.2.2-r0: minimal C kernel for Jupyter
- python3-jupyterthemes 0.20.0-r0: themes for Jupyter notebooks
- python3-lesscpy 0.15.1-r0: provide Python LESS compiler
- x-linux-ai-tool 5.1.0-r0: provide X-Linux-AI installer tool
- x-linux-isp-tool 5.1.0-r0: provide X-Linux-ISP installer tool


## Maintainers
- Jean-Marc Bouche <jean-marc.bouche@st.com>
