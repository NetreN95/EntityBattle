plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
}

android {
//    namespace = "ru.maxtere.core.coroutines"
    namespace = "ru.maxtere.sdk.coroutines"
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
                api(libs.kotlin.coroutines.core)
            }
        }
        androidMain {
            dependencies {
                api(libs.kotlin.coroutines.android)

            }
        }
        jvmMain {
            dependencies {
                api(libs.kotlin.coroutines.swing)
            }
        }
    }
}