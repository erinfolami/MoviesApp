package com.example.moviesapp.features.search.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.domain.SearchMoviesUseCase
import com.example.moviesapp.model.data.SearchMovies
import com.example.moviesapp.network.model.SearchMoviesDTO
import com.example.moviesapp.network.retrofit.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchMoviesViewModel @Inject constructor(
    private val searchMoviesUseCase: SearchMoviesUseCase
) : ViewModel() {

    private val _searchedMovies =
        MutableStateFlow<List<SearchMovies>>(emptyList())

    val searchedMovies = _searchedMovies.asStateFlow()


    fun searchMovies(query: String) {
        viewModelScope.launch {
            searchMoviesUseCase(query).collect { result ->
                _searchedMovies.value = result
            }
        }
    }

}