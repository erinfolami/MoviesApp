package com.example.moviesapp.data.repository.local

import com.example.moviesapp.model.TrendingMoviesEntity


interface LocalMoviesAppRepository {

    suspend fun getAllTrendingMovies(): List<TrendingMoviesEntity>

    suspend fun insertAll(movies: List<TrendingMoviesEntity>)

    suspend fun clearAll()
}