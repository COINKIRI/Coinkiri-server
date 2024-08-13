plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "Coinkiri-server"
include("coinkiri-domain")
include("coinkiri-application")
include("coinkiri-framework")
include("coinkiri-bootstrap")
include("persistence")
