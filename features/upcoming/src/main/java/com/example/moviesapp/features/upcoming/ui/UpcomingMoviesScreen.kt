package com.example.moviesapp.features.upcoming.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviesapp.features.upcoming.ui.viewmodel.UpcomingViewModel

@Composable
internal fun UpcomingMoviesRoute(
    modifier: Modifier = Modifier,
    viewModel: UpcomingViewModel = hiltViewModel(),
) {

    val state by viewModel.upcomingMovies.collectAsState()

    Text(text = "Trending${state.data?.upcomingResults?.get(0)}")


}


