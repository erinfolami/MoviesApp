package com.example.moviesapp.data.repository

import com.example.moviesapp.network.datasource.MoviesRemoteDataSource
import com.example.moviesapp.network.model.TrendingMoviesDTO
import com.example.moviesapp.network.model.UpcomingMoviesDTO
import com.example.moviesapp.network.retrofit.BaseApiResponse
import com.example.moviesapp.network.retrofit.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviesAppRepositoryImpl @Inject constructor(
    private val moviesRemoteDataSource: MoviesRemoteDataSource
) : MoviesAppRepository, BaseApiResponse() {

    override suspend fun getTendingMovies(): Flow<NetworkResult<TrendingMoviesDTO>> {
        return flow {
            emit(safeApiCall { moviesRemoteDataSource.getTrendingMovies() })
        }
    }

    override suspend fun getUpcomingMovies(): Flow<NetworkResult<UpcomingMoviesDTO>> {
        return flow {
            emit(safeApiCall { moviesRemoteDataSource.getUpcomingMovies() })
        }
    }


}