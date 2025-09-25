plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "ru.maxtere.sample.app.android"
    compileSdk = libs.versions.android.compileSdk.get().toInt()


    defaultConfig {
        applicationId = "ru.maxtere.sample"
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.12"
    }
}

kotlin {
    androidTarget()
    sourceSets {
        androidMain {
            dependencies {
                implementation(projects.sdk.platform)
//                api(projects.sdk.ui.compose)
                implementation(projects.common.main)
//                implementation(projects.sdk.database.sqlDelight)

//                implementation(projects.common.experiments)
                implementation(projects.sdk.ui.compose)
            }
        }
    }
}