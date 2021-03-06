DESCRIPTION = "Text::CSV_XS provides facilities for the composition and decomposition \
of comma-separated values. An instance of the Text::CSV_XS class will \
combine \
fields into a \"CSV\" string and parse a \"CSV\" string into fields."

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-2.0"
PR = "r0"

MAINTAINER=	"Poky <poky@yoctoproject.org>"
HOMEPAGE=	"https://metacpan.org/release/Text-CSV_XS"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "https://cpan.metacpan.org/authors/id/H/HM/HMBRAND/Text-CSV_XS-1.19.tgz"

SRC_URI[md5sum] = "d25bb37e43a836a3f396faf387307548"
SRC_URI[sha256sum] = "bcde887f613c6a50b0ce8f714cd2463570f5809f26581615690cfb424d2a7c16"
RRECOMMENDS_${PN} += "encode-perl"

S = "${WORKDIR}/Text-CSV_XS-${PV}"

inherit cpan

do_compile() {
	export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
	cpan_do_compile
}

BBCLASSEXTEND = "native"
