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
  PC $> git clone https://github.com/STMicroelectronics/meta-st-pkgrepo-updates.git -b <branch>
  ```

where <branch> corresponds to the STM32MP1 Distribution Package version.

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
- hplip 3.22.10-r1: fix systemd pre and post-installation from template service file and add missing dependency to python3-dbus
- samba 4.17.5-r1: fix missing directories /var/log/samba and /run/samba at package installation

## List of added packages in the layer meta-st-pkgrepo-updates
- libpqxx 7.7.5-r0: provide C++ PostgreSQL connector
- openvpn-install 1.0-r0: ease OpenVPN server installation
- python3-azure-core 1.26.4-r0: provide Azure core shared client library
- python3-azure-identity 1.12.0-r0: Azure identity library
- python3-azure-servicebus 7.9.0-r0: Azure service bus client library
- python3-azure-storage-blob 12.16.0-r0: Azure storage blobs client library
- python3-ixnetwork-restpy 1.1.9-r0: IxNetwork REST API client
- python3-msal 1.22.0-r0: Microsoft authentication library
- python3-msrest 0.7.1-r0: AutoRest swagger generator client runtime
- python3-uamqp 1.6.4-r0: AMQP 1.0 client library

## Maintainers
- Jean-Marc Bouche <jean-marc.bouche@st.com>
