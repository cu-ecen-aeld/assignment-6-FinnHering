# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f098732a73b5f6f3430472f5b094ffdb"

SRC_URI = "git://git@github.com/FinnHering/aeld-assignment-7.git;protocol=ssh;branch=main \
           file://0001-only-build-scull-and-modules.patch \
           file://files/981-misc-modules.sh \
           "

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "8e568f822b6a4b7eacac074d4eb9cd427e1d245c"

S = "${WORKDIR}/git"

inherit update-rc.d


INITSCRIPT_NAME = "981-misc-modules.sh"
INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_PARAMS = "defaults 99"


inherit module
FILES:${PN} += "${sysconfdir}/init.d/981-misc-modules.sh"


EXTRA_OEMAKE:append:task-install = " -C ${STAGING_KERNEL_DIR} M=${S}/misc-modules"
EXTRA_OEMAKE += "KERNELDIR=${STAGING_KERNEL_DIR}"

do_install() {
    module_do_install
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/files/981-misc-modules.sh ${D}${sysconfdir}/init.d/981-misc-modules.sh
}

RPROVIDES:${PN} += "kernel-module-hello"