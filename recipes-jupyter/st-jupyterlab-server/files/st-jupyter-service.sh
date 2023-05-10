#!/bin/sh -

jupyter_kernel_depends() {
	local version_major
	version_major=$(python3 --version | awk '{print $NF}')
	version_major=${version_major%.*}
	if [ -f /usr/lib/python"${version_major}"/site-packages/jupyter_c_kernel/install_c_kernel ];
	then
		install_c_kernel --user
	fi
}

is_jupyterlab_running(){
	# get jupyter-lab PID if existing
	jupyterlab_PID=$(ps -ef | grep jupyter-lab | grep -v grep | awk '{print $2}')
	if [ "$jupyterlab_PID" != "" ]
	then
		# Juptyer-lab is running
		return 0
	else
		# Jupyter-lab is not running
		return 1
	fi
}

stop_jupyterlab() {
	if is_jupyterlab_running
	then
		ps -ef | grep jupyter-lab | grep -v grep | awk '{print $2}' | xargs kill
	else
		echo "Jupyter-lab is not running."
	fi
}

start_jupyterlab() {
	if is_jupyterlab_running
	then
		echo "Jupyter-lab is already running."
	else
		# command to start jupyter-lab
		jupyter-lab --no-browser --ip=0.0.0.0 --notebook-dir=/home/jupyter
	fi
}


case $1 in
	-h|--help)
		echo ""
		echo "Usage: $0 start/stop"
		echo ""
		exit 1
		;;

	start)
		jupyter_kernel_depends
		start_jupyterlab
		echo
		;;

	stop)
		stop_jupyterlab
		echo
		;;

	*)
		echo ""
		echo "option is missing:"
		echo "     - 'start' to start jupyter-lab server"
		echo "     - 'stop' to stop jupyter-lab server"
		echo "run '$0 -h' for help"
		exit
		;;
esac

