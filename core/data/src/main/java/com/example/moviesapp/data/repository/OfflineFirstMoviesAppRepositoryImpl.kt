package com.example.moviesapp.data.repository

import com.example.moviesapp.data.model.asEntityList
import com.example.moviesapp.data.repository.local.LocalMoviesAppRepository
import com.example.moviesapp.data.repository.remote.RemoteMoviesAppRepository
import com.example.moviesapp.model.asExternalModel
import com.example.moviesapp.model.data.TrendingMovies
import com.example.moviesapp.network.retrofit.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OfflineFirstMoviesAppRepositoryImpl @Inject constructor(
    private val localMoviesAppRepository: LocalMoviesAppRepository,
    private val remoteMoviesAppRepository: RemoteMoviesAppRepository
) : OfflineFirstMoviesAppRepository {

    override suspend fun syncTrendingMovies(): Flow<List<TrendingMovies>> {
        val localMovies = localMoviesAppRepository.getAllTrendingMovies()
        return if (localMovies.isNotEmpty()) {
            flow {
                emit(localMovies.map { it.asExternalModel() })
            }
        } else {
            flow {
                remoteMoviesAppRepository.getTendingMovies().collect { networkResult ->
                    when (networkResult) {
                        is NetworkResult.Success -> {
                            val trendingMovies = networkResult.data?.asEntityList()
                            // Save to local repository
                            if (trendingMovies != null) {
                                localMoviesAppRepository.insertAll(trendingMovies)
                            }
                            // Emit the local data
                            emit(localMovies.map { it.asExternalModel() })
                        }
                        is NetworkResult.Error -> {
                            // Handle error, could emit cached data or a different state
                            emit(localMovies.map { it.asExternalModel() })
                        }
                        is NetworkResult.Loading -> {
                            // Emit loading state if necessary
                        }
                    }
                }
            }
        }
    }
}