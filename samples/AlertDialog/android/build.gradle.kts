plugins {
    id("org.jetbrains.compose") version "1.0.0-beta3"
    id("com.android.application")
    kotlin("android")
}

group = "dev.atsushieno"
version = "1.0"

dependencies {
    implementation(project(":samples:AlertDialog:common"))
    implementation("androidx.activity:activity-compose:1.4.0")
}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "dev.atsushieno.android"
        minSdkVersion(24)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}