package com.example.moviesapp.data.repository

import com.example.moviesapp.model.TrendingMoviesEntity
import com.example.moviesapp.model.data.TrendingMovies
import com.example.moviesapp.model.data.UpcomingMovies
import kotlinx.coroutines.flow.Flow

interface OfflineFirstMoviesAppRepository {

    suspend fun syncTrendingMovies(): Flow<List<TrendingMovies>>

    suspend fun syncUpcomingMovies(): Flow<List<UpcomingMovies>>

}