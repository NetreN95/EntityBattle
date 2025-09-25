plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(libs.coil3.compose)
                api(libs.coil3.network.okhttp)
            }
        }
    }
}