plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

android {
//    namespace = "ru.maxtere.core.ui.compose"
    namespace = "ru.maxtere.sdk.ui.compose"
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
                api(compose.runtime)
                api(compose.ui)
                api(compose.foundation)
                api(compose.uiTooling)
                api(compose.preview)
                api(compose.material)
                api(compose.materialIconsExtended)
            }
        }

        jvmMain {
            dependencies {
                api(compose.desktop.currentOs)
                api(compose.desktop.common)
                api(libs.compose.desktop.material)
//                api(compose.desktop.windows_x64)
            }
        }

        androidMain {
            dependencies {
                api(libs.android.androidx.activity)
            }
        }
    }
}