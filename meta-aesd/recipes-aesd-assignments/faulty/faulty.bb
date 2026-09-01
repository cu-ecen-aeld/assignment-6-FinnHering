# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
LICENSE = "CLOSED" 
SRC_URI = "file://files/981-faulty-module.sh \
           "

# Modify these as desired
PV = "1.0"
inherit update-rc.d

INITSCRIPT_NAME = "981-faulty-module.sh"
INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_PARAMS = "defaults 99"

FILES:${PN} += "${sysconfdir}/init.d/981-faulty-module.sh"


do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/files/981-faulty-module.sh ${D}${sysconfdir}/init.d/981-faulty-module.sh

}