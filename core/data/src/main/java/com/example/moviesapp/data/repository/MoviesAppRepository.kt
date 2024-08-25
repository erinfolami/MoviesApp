package com.example.moviesapp.data.repository

import com.example.moviesapp.network.model.TrendingMoviesDTO
import com.example.moviesapp.network.retrofit.NetworkResult
import kotlinx.coroutines.flow.Flow

interface MoviesAppRepository {

    suspend fun getTendingMovies(): Flow<NetworkResult<TrendingMoviesDTO>>
}