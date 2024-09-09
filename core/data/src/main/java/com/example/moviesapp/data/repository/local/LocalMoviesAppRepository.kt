package com.example.moviesapp.data.repository.local

import com.example.moviesapp.model.TrendingMoviesEntity
import com.example.moviesapp.model.UpcomingMoviesEntity


interface LocalMoviesAppRepository {

    suspend fun getAllTrendingMovies(): List<TrendingMoviesEntity>

    suspend fun insertAllTrendingMovies(movies: List<TrendingMoviesEntity>)

    suspend fun clearAllTrendingMovies()


    suspend fun getAllUpcomingMovies(): List<UpcomingMoviesEntity>

    suspend fun insertAllUpcomingMovies(movies: List<UpcomingMoviesEntity>)

    suspend fun clearAllUpcomingMovies()
}