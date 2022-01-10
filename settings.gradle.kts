pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    
}
rootProject.name = "compose-mpp"

// Library
include(":compose-mpp")

// SAMPLES
include(":samples:AlertDialog:common")
include(":samples:AlertDialog:android")
include(":samples:AlertDialog:desktop")

include(":samples:DropDownMenu:common")
include(":samples:DropDownMenu:android")
include(":samples:DropDownMenu:desktop")
