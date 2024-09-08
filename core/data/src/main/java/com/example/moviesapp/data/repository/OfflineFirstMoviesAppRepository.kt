package com.example.moviesapp.data.repository

import com.example.moviesapp.model.TrendingMoviesEntity
import com.example.moviesapp.model.data.TrendingMovies
import kotlinx.coroutines.flow.Flow

interface OfflineFirstMoviesAppRepository {

    suspend fun syncTrendingMovies(): Flow<List<TrendingMovies>>

}