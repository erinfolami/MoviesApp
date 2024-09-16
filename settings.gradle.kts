pluginManagement {
    include(":build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
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
        mavenCentral()
    }
}

rootProject.name = "MoviesApp"
include(":app")

include(":features:trending")
include(":features:upcoming")
include(":features:search")

include(":core:ui")
include(":core:common")
include(":core:designsystem")
include(":core:domain")
include(":core:network")
include(":core:data")
include(":core:database")
include(":core:model")

include(":sync:work")
