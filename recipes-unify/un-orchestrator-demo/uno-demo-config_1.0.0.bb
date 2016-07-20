SUMMARY = "Universal Node orchestrator demo"
DESCRIPTION = "The Universal Node orchestrator demo configuration pass through"
HOMEPAGE = "https://github.com/bisdn/un-orchestrator"
LICENSE = "CLOSED"

PR = "r2"

SRC_URI = "file://EnvironmentFile \
        file://uno-config.ini "

SRC_URI += "file://config.xml"
SRC_URI += "file://universal-node1-example.xml"

RDEPENDS_${PN} = "un-orchestrator"

FILES_${PN} += "${sysconfdir}/uno/prestart.sh"

FILES_${PN} += "${sysconfdir}/uno-name-resolver/config/"
FILES_${PN} += "/opt/virtualizer/config/"

do_install() {
        install -d ${D}${sysconfdir}/default/node-orchestrator
        install -m 0644 ${WORKDIR}/uno-config.ini ${D}${sysconfdir}/default/node-orchestrator/demo-config.ini

        install -d ${D}${sysconfdir}/uno
        install -m 0644 ${WORKDIR}/EnvironmentFile ${D}${sysconfdir}/uno/env

		install -d ${D}${sysconfdir}/uno-name-resolver/config/
        install -m 0644 ${WORKDIR}/config.xml ${D}${sysconfdir}/uno-name-resolver/config/

		install -d ${D}/opt/virtualizer/config/
        install -m 0644 ${WORKDIR}/universal-node1-example.xml ${D}/opt/virtualizer/config/
}

CONFFILES_${PN} += "${sysconfdir}/uno/env"
CONFFILES_${PN} += "${sysconfdir}/uno-name-resolver/config/config.xml"
CONFFILES_${PN} += "/opt/virtualizer/config/universal-node1-example.xml"

