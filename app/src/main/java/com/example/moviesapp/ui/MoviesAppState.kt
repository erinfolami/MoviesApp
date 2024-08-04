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



package com.example.moviesapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.tracing.trace
import com.example.moviesapp.features.search.navigation.SEARCH_ROUTE
import com.example.moviesapp.features.search.navigation.navigateToSearchMovies
import com.example.moviesapp.features.upcoming.navigation.UPCOMING_ROUTE
import com.example.moviesapp.features.upcoming.navigation.navigateToUpcomingMovies
import com.example.moviesapp.navigation.TopLevelDestination
import com.example.moviesapp.navigation.TopLevelDestination.TRENDING_MOVIES
import com.example.moviesapp.navigation.TopLevelDestination.UPCOMING_MOVIES
import com.example.moviesapp.navigation.TopLevelDestination.SEARCH_MOVIES
import com.example.moviesapp.trending.navigation.TRENDING_ROUTE
import com.example.moviesapp.trending.navigation.navigateToTrendingMovies
import kotlinx.coroutines.CoroutineScope


@Composable
fun rememberMoviesAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): MoviesAppState {
//    NavigationTrackingSideEffect(navController)
    return remember(
        navController,
        coroutineScope,
    ) {
        MoviesAppState(
            navController = navController,
            coroutineScope = coroutineScope
        )
    }
}


@Stable
class MoviesAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            TRENDING_ROUTE -> TRENDING_MOVIES
            UPCOMING_ROUTE -> UPCOMING_MOVIES
            SEARCH_ROUTE -> SEARCH_MOVIES
            else -> null
        }

//    val isOffline = networkMonitor.isOnline
//        .map(Boolean::not)
//        .stateIn(
//            scope = coroutineScope,
//            started = SharingStarted.WhileSubscribed(5_000),
//            initialValue = false,
//        )

    /**
     * Map of top level destinations to be used in the TopBar, BottomBar and NavRail. The key is the
     * route.
     */
    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries



    /**
     * UI logic for navigating to a top level destination in the app. Top level destinations have
     * only one copy of the destination of the back stack, and save and restore state whenever you
     * navigate to and from it.
     *
     * @param topLevelDestination: The destination the app needs to navigate to.
     */
    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }

            when (topLevelDestination) {
                TRENDING_MOVIES -> navController.navigateToTrendingMovies(topLevelNavOptions)
                UPCOMING_MOVIES -> navController.navigateToUpcomingMovies(topLevelNavOptions)
                SEARCH_MOVIES -> navController.navigateToSearchMovies(topLevelNavOptions)
            }
        }
    }

//    fun navigateToSearch() = navController.navigateToSearch()
}

//
///**
// * Stores information about navigation events to be used with JankStats
// */
//@Composable
//private fun NavigationTrackingSideEffect(navController: NavHostController) {
//    TrackDisposableJank(navController) { metricsHolder ->
//        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
//            metricsHolder.state?.putState("Navigation", destination.route.toString())
//        }
//
//        navController.addOnDestinationChangedListener(listener)
//
//        onDispose {
//            navController.removeOnDestinationChangedListener(listener)
//        }
//    }
//}




