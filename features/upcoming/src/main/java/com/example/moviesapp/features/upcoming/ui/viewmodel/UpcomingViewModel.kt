package com.example.moviesapp.features.upcoming.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.domain.GetUpcomingMoviesUseCase
import com.example.moviesapp.network.model.UpcomingMoviesDTO
import com.example.moviesapp.network.retrofit.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UpcomingViewModel @Inject constructor(
    private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase
) : ViewModel() {

    init {
        getUpcomingMovies()
    }

    private val _upcomingMovies =
        MutableStateFlow<NetworkResult<UpcomingMoviesDTO>>(NetworkResult.Loading())

    val upcomingMovies = _upcomingMovies.asStateFlow()



    private fun getUpcomingMovies() {
        viewModelScope.launch {
            getUpcomingMoviesUseCase().collect { result ->
                _upcomingMovies.value = result
            }
        }
    }
}