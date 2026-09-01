#!/bin/sh

case "$1" in
    start)
        modprobe hello
        ;;
    stop)
        rmmod hello
        ;;
    *)
        echo "ldd-mdoules {start|stop}"
        exit 1
        ;;
esac


