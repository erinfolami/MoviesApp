package com.example.moviesapp.network.retrofit

import com.example.moviesapp.network.model.TrendingMoviesDTO
import retrofit2.Response
import retrofit2.http.GET

/**
 * Retrofit API declaration for MoviesApp Network API
 */

interface MovieApiService {
    @GET("trending/movie/day")
    suspend fun getTrendingMovies(
    ): Response<TrendingMoviesDTO>
}


