package com.example.moviesapp.domain

import com.example.moviesapp.data.repository.MoviesAppRepository
import com.example.moviesapp.network.model.TrendingMoviesDTO
import com.example.moviesapp.network.model.UpcomingMoviesDTO
import com.example.moviesapp.network.retrofit.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * A use case which returns the Upcoming Movies.
 */
class GetUpcomingMoviesUseCase @Inject constructor(
    private val moviesAppRepository: MoviesAppRepository
) {
    suspend operator fun invoke() : Flow<NetworkResult<UpcomingMoviesDTO>> {
        return  moviesAppRepository.getUpcomingMovies()
    }
}