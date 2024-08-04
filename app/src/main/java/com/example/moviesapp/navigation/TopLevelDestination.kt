package com.example.moviesapp.navigation

/*
 * Copyright 2022 The Android Open Source Project
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


import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.moviesapp.designsystem.icon.MoviesIcon
import com.example.weatherapp.R

/**
 * Type for the top level destinations in the application. Each of these destinations
 * can contain one or more screens (based on the window size). Navigation from one screen to the
 * next within a single destination will be handled directly in composables.
 */
enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    TRENDING_MOVIES(
        selectedIcon =  MoviesIcon.Trending,
        unselectedIcon = MoviesIcon.Trending,
        iconTextId = R.string.bottom_bar_trending,
        titleTextId = R.string.bottom_bar_trending,
    ),
    UPCOMING_MOVIES(
        selectedIcon = MoviesIcon.Upcoming,
        unselectedIcon = MoviesIcon.Upcoming,
        iconTextId = R.string.bottom_bar_upcoming,
        titleTextId = R.string.bottom_bar_upcoming,
    ),
    SEARCH_MOVIES(
        selectedIcon = MoviesIcon.Search,
        unselectedIcon = MoviesIcon.Upcoming,
        iconTextId = R.string.bottom_bar_search,
        titleTextId = R.string.bottom_bar_search,
    ),
}


