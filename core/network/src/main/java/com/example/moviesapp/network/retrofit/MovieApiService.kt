package com.example.moviesapp.network.retrofit

import com.example.moviesapp.network.model.SearchMoviesDTO
import com.example.moviesapp.network.model.TrendingMoviesDTO
import com.example.moviesapp.network.model.UpcomingMoviesDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit API declaration for MoviesApp Network API
 */

interface MovieApiService {
    @GET("trending/movie/day")
    suspend fun getTrendingMovies(
    ): Response<TrendingMoviesDTO>


    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
    ): Response<UpcomingMoviesDTO>

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String
    ): Response<SearchMoviesDTO>


}


