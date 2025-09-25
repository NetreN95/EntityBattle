plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
//    alias(libs.plugins.android.library)
}

//android {
//    namespace = "ru.maxtere.notes.di"
//    compileSdk = libs.versions.android.compileSdk.get().toInt()
//
//    defaultConfig {
//        minSdk = libs.versions.android.minSdk.get().toInt()
//    }
//
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_21
//        targetCompatibility = JavaVersion.VERSION_21
//    }
//}

kotlin {
    jvm()
//    androidTarget()

    sourceSets {
        commonMain {
            dependencies {
                api(projects.sdk.coroutines)
                api(projects.sdk.serialization.kotlin)
                implementation(projects.sdk.ui.compose)

                api(projects.sdk.di.koin)
                api(projects.sdk.ui.decompose)
            }
        }
    }
}