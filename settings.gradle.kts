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
include("domain")

// application
include("application")

// common
include("common")

// infrastructures
include(":persistence")
project(":persistence").projectDir = file("./infrastructure/persistence")

include(":oauth2")
project(":oauth2").projectDir = file("./infrastructure/oauth2")

include(":redis")
project(":redis").projectDir = file("./infrastructure/redis")

include(":upbit")
project(":upbit").projectDir = file("./infrastructure/upbit")

// bootstraps
include(":api")
project(":api").projectDir = file("./bootstrap/api")
