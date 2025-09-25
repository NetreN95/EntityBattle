// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
//    `kotlin-dsl`
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.compose.multiplatform) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.sqlDelight) apply false
    alias(libs.plugins.moko.res) apply false
}

allprojects.onEach { project ->
    project.afterEvaluate {
        with(project.plugins) {
            if (hasPlugin(libs.plugins.kotlin.multiplatform.get().pluginId)) {
                task("testClasses")
            }

//            if ( (hasPlugin(libs.plugins.android.library.get().pluginId)) || hasPlugin(libs.plugins.android.application.get().pluginId) ){
//            }
        }
    }
}