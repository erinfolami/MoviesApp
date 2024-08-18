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



include(":core:ui")
include(":core:common")
include(":core:network")
include(":core:database")



include(":features:trending")

include(":core:designsystem")
include(":features:upcoming")
include(":features:search")


include(":core:domain")
