package com.example.moviesapp.features.search.ui


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.moviesapp.features.search.ui.viewmodel.SearchMoviesViewModel


@Composable
internal fun SearchMoviesRoute(
    modifier: Modifier = Modifier,
    viewModel: SearchMoviesViewModel = hiltViewModel(),
) {

    val state = viewModel.searchedMovies.collectAsState()

        Text(text = "Search${state.value.data?.results}")



}

