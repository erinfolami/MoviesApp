package com.example.moviesapp.trending.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.domain.GetTrendingMoviesUseCase
import com.example.moviesapp.network.model.TrendingMoviesDTO
import com.example.moviesapp.network.retrofit.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingViewModel @Inject constructor(
    private val getTrendingMoviesUseCase: GetTrendingMoviesUseCase
) : ViewModel() {

    init {
        getTrendingMovies()
    }

    private val _trendingMovies =
        MutableStateFlow<NetworkResult<TrendingMoviesDTO>>(NetworkResult.Loading())

    val trendingMovies = _trendingMovies.asStateFlow()



    private fun getTrendingMovies() {
        viewModelScope.launch {
            getTrendingMoviesUseCase().collect { result ->
                _trendingMovies.value = result
            }
        }
    }

}