package com.example.moviesapp.data.repository.remote

import com.example.moviesapp.network.datasource.MoviesRemoteDataSource
import com.example.moviesapp.network.model.SearchMoviesDTO
import com.example.moviesapp.network.model.TrendingMoviesDTO
import com.example.moviesapp.network.model.UpcomingMoviesDTO
import com.example.moviesapp.network.retrofit.BaseApiResponse
import com.example.moviesapp.network.retrofit.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteMoviesAppRepositoryImpl @Inject constructor(
    private val moviesRemoteDataSource: MoviesRemoteDataSource
) : RemoteMoviesAppRepository, BaseApiResponse() {

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

    override suspend fun searchMovies(): Flow<NetworkResult<SearchMoviesDTO>> {
        return flow {
            emit(safeApiCall { moviesRemoteDataSource.searchMovies() })
        }
    }


}