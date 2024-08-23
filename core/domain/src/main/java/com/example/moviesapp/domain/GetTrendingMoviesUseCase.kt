package com.example.moviesapp.domain

import com.example.moviesapp.domain.repository.MoviesAppRepository
import com.example.moviesapp.network.model.TrendingMoviesDTO
import com.example.moviesapp.network.retrofit.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * A use case which returns the Trending Movies.
 */
class GetTrendingMoviesUseCase @Inject constructor(
    private val moviesAppRepository: MoviesAppRepository
) {
   suspend operator fun invoke() : Flow<NetworkResult<TrendingMoviesDTO>> {
     return  moviesAppRepository.getTendingMovies()
   }
}