package com.example.moviesapp.domain

import com.example.moviesapp.data.repository.OfflineFirstMoviesAppRepository
import com.example.moviesapp.data.repository.remote.RemoteMoviesAppRepository
import com.example.moviesapp.model.data.UpcomingMovies
import com.example.moviesapp.network.model.SearchMoviesDTO
import com.example.moviesapp.network.retrofit.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * A use case which returns the Search Movies.
 */
class SearchMoviesUseCase @Inject constructor(
    private val repository: RemoteMoviesAppRepository
) {
    suspend operator fun invoke() : Flow<NetworkResult<SearchMoviesDTO>> {
        return  repository.searchMovies()
    }
}