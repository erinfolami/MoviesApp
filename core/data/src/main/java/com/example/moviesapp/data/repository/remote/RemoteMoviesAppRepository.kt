package com.example.moviesapp.data.repository.remote

import com.example.moviesapp.network.model.TrendingMoviesDTO
import com.example.moviesapp.network.model.UpcomingMoviesDTO
import com.example.moviesapp.network.retrofit.NetworkResult
import kotlinx.coroutines.flow.Flow

interface RemoteMoviesAppRepository {

    suspend fun getTendingMovies(): Flow<NetworkResult<TrendingMoviesDTO>>

    suspend fun getUpcomingMovies(): Flow<NetworkResult<UpcomingMoviesDTO>>
}