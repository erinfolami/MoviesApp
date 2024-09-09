package com.example.moviesapp.domain

import com.example.moviesapp.data.repository.OfflineFirstMoviesAppRepository
import com.example.moviesapp.data.repository.remote.RemoteMoviesAppRepository
import com.example.moviesapp.model.data.UpcomingMovies
import com.example.moviesapp.network.model.UpcomingMoviesDTO
import com.example.moviesapp.network.retrofit.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * A use case which returns the Upcoming Movies.
 */
class GetUpcomingMoviesUseCase @Inject constructor(
    private val offlineFirstMoviesAppRepository: OfflineFirstMoviesAppRepository
) {
    suspend operator fun invoke() : Flow<List<UpcomingMovies>> {
        return  offlineFirstMoviesAppRepository.syncUpcomingMovies()
    }
}