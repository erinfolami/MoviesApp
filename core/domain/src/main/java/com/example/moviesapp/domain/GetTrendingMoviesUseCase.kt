package com.example.moviesapp.domain

import com.example.moviesapp.data.repository.OfflineFirstMoviesAppRepository
import com.example.moviesapp.model.data.TrendingMovies
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * A use case which returns the Trending Movies.
 */
class GetTrendingMoviesUseCase @Inject constructor(
    private val offlineFirstMoviesAppRepository: OfflineFirstMoviesAppRepository
) {
   suspend operator fun invoke() : Flow<List<TrendingMovies>> {
     return  offlineFirstMoviesAppRepository.syncTrendingMovies()
   }
}