pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "Coinkiri-server"

// domain
include("coinkiri-domain")

// application
include("coinkiri-application")

// infrastructures
include(":persistence")
project(":persistence").projectDir = file("./coinkiri-infrastructure/persistence")

include(":oauth2")
project(":oauth2").projectDir = file("./coinkiri-infrastructure/oauth2")

include(":redis")
project(":redis").projectDir = file("./coinkiri-infrastructure/redis")

// bootstraps
include(":api")
project(":api").projectDir = file("./coinkiri-bootstrap/api")
include("redis")
include("common")
