package com.example.moviesapp.network.datasource

import com.example.moviesapp.network.model.TrendingMoviesDTO
import retrofit2.Response


/**
 * Interface representing network calls to the MoviesApp backend
 */


interface MoviesRemoteDataSource {
    suspend fun getTrendingMovies() : Response<TrendingMoviesDTO>

}