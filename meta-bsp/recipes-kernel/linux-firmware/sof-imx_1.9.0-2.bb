# Copyright (C) 2020-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Sound Open Firmware"
HOMEPAGE = "https://www.sofproject.org"
SECTION = "kernel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENCE;md5=0f00d99239d922ffd13cabef83b33444"

SRC_URI = "${FSL_MIRROR}/${BPN}-${PV}.tar.gz"
SRC_URI[md5sum] = "5fceb10a8dae911c1462741b8a9744b5"
SRC_URI[sha256sum] = "7391e73576fa0a4ecee94e85052e000fa6840b32f9602d2e265ad37a53cf6ee6"

inherit allarch

do_install() {
    # Install sof and sof-tplg folder
    install -d ${D}${nonarch_base_libdir}/firmware/imx/
    cp -r sof* ${D}${nonarch_base_libdir}/firmware/imx/

    # Work-around to use GCC version of firmware of i.MX 8ULP
    if [ -e ${D}${nonarch_base_libdir}/firmware/imx/sof-xcc ]; then
        cd ${D}${nonarch_base_libdir}/firmware/imx/sof-xcc
        SOF_8ULP_FILES="sof-imx8ulp.ldc sof-imx8ulp.ri"
        for sof_file in $SOF_8ULP_FILES
        do
            if [ ! -e $sof_file ]; then
                ln -s ../sof-gcc/$sof_file $sof_file
            fi
        done
        cd -
    fi
}

FILES_${PN} = "${nonarch_base_libdir}/firmware/imx"
