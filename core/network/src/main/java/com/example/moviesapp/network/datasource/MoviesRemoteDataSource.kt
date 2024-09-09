package com.example.moviesapp.network.datasource

import com.example.moviesapp.network.model.SearchMoviesDTO
import com.example.moviesapp.network.model.TrendingMoviesDTO
import com.example.moviesapp.network.model.UpcomingMoviesDTO
import retrofit2.Response


/**
 * Interface representing network calls to the MoviesApp backend
 */


interface MoviesRemoteDataSource {
    suspend fun getTrendingMovies() : Response<TrendingMoviesDTO>

    suspend fun getUpcomingMovies(): Response<UpcomingMoviesDTO>

    suspend fun searchMovies(): Response<SearchMoviesDTO>
}