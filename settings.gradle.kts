enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }

            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()

        maven {
            url = uri("https://company/com/maven2")
        }
    }
}
rootProject.name = "EntityBattle"

includeProject()

fun includeProject() {
    includeSDK()
    includeShared()
    includeApp()
}

fun includeSDK() {
    include(":SDK:coroutines")
    include(":SDK:settings")
    include(":SDK:DI:koin")
    include(":SDK:platform")
    include(":SDK:serialization:kotlin")
    include(":SDK:UI:compose")
    include(":SDK:UI:viewModel:jetbrains")
    include(":SDK:UI:decompose")
    include(":SDK:UI:coil3")
}

fun includeShared() {
    includeMain()
}

fun includeMain() {
    include(":shared:main")
}

fun includeApp() {
//    include(":app:android")
    include(":app:desktop")
}