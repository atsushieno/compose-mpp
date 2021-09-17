pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    
}
rootProject.name = "compose-mpp"


include(":compose-mpp")
include(":samples:AlertDialog:common")
include(":samples:AlertDialog:android")
include(":samples:AlertDialog:desktop")
