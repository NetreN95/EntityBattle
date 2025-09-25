plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

//android {
//    namespace = "ru.maxtere.core.di.koin"
//    namespace = "ru.maxtere.sdk.di.koin"
//}

android {
//    namespace = "ru.maxtere.core.di.koin"
    namespace = "ru.maxtere.sdk.di.koin"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}


kotlin {
    jvm()
    androidTarget()
    sourceSets {
        commonMain {
            dependencies {
                api(libs.koin.core)
                api(libs.koin.core.viewmodel)
                api(libs.koin.compose.viewmodel)
                api(libs.koin.compose)
            }
        }
        androidMain {
            dependencies {
                api(libs.koin.android)
            }
        }
    }
}