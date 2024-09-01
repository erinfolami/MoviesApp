package com.example.moviesapp.trending.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviesapp.trending.ui.viewmodel.TrendingViewModel


@Composable
internal fun TrendingMoviesRoute(
    modifier: Modifier = Modifier,
    viewModel: TrendingViewModel = hiltViewModel(),
) {

    val state by viewModel.trendingMovies.collectAsState()

    Text(text = "Trending${state.data?.trendingResults?.get(0)}")
    
}

