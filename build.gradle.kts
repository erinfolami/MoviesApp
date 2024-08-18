// Top-level build file where you can add configuration options common to all sub-projects/modules.

/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

buildscript {
    repositories {
        google()
        mavenCentral()

        // Android Build Server
        maven { url = uri("../nowinandroid-prebuilts/m2repository") }
    }



//uncomment this just in case u face issue with build logic
//because build logic does not seem set up properly yet, as it doesn't
//include convention in the 'Android' directory structure (excluding project structure)

//    dependencies {
//        classpath(libs.android.gradlePlugin)
//        classpath (libs.android.tools.common)
//        classpath (libs.compose.gradlePlugin)
//
//    }

}



// Lists all plugins used throughout the project
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.secrets) apply false
    alias(libs.plugins.kotlin.serialization) apply false
//    alias(libs.plugins.hilt) apply false

}