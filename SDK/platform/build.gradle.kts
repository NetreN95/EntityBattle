plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

android {
//    namespace = "ru.maxtere.core.platform"
    namespace = "ru.maxtere.sdk.platform"
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
        androidMain {
            dependencies {
                api(libs.android.androidx.activity.compose)
                api(libs.android.androidx.activity.ktx)
                api(libs.android.androidx.appcompat)
            }
        }
    }
}