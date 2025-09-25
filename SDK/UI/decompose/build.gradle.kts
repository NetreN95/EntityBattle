plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

kotlin {
    jvm()
    sourceSets {
        commonMain {
            dependencies {
                api(libs.decompose)
                api(libs.decompose.compose)
                api(libs.essenty.lifecycle)

                implementation(projects.sdk.coroutines)
            }
        }
    }
}