plugins {
    alias(libs.plugins.kotlin.multiplatform)
}


kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(libs.kotlin.serialization.gradlePlugin)
                api(libs.kotlin.serialization.core)
                api(libs.kotlin.serialization.json)
            }
        }
    }
}