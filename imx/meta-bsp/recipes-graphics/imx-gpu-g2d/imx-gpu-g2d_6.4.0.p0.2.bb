require recipes-graphics/imx-gpu-g2d/imx-gpu-g2d_6.2.4.p1.8.bb

LIC_FILES_CHKSUM = "file://COPYING;md5=72c0f70181bb6e83eee6aab8de12a9f3" 

FSLBIN_NAME_arm = "${PN}-${PV}-${TARGET_ARCH}"

SRC_URI[aarch64.md5sum] = "0d472bfb25f3ec2da9534f061fb9129e"
SRC_URI[aarch64.sha256sum] = "0129f5eeaae72d7db83dfa02b8fe4a4637ababecf55f67357a16b39de262a33f"
SRC_URI[arm.md5sum] = "f1543e252145a500819ce95ea415f6db"
SRC_URI[arm.sha256sum] = "ce9471c2a7fe06c77b8745d8ae40518498cc118f427a64c6ba975cb9a75ae132"
