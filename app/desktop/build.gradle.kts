plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

dependencies {
    implementation(projects.shared.main)
    implementation(projects.sdk.ui.compose)
}

compose.desktop {
    application {
        mainClass = "MainKt"
    }
}