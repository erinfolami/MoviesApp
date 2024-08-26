package com.example.moviesapp.network.datasource

import com.example.moviesapp.network.model.TrendingMoviesDTO
import com.example.moviesapp.network.retrofit.MovieApiService
import retrofit2.Response
import javax.inject.Inject

class MoviesRemoteDataSourceImpl @Inject constructor(private val movieApiService: MovieApiService) :
    MoviesRemoteDataSource {
    override suspend fun getTrendingMovies(): Response<TrendingMoviesDTO> =
        movieApiService.getTrendingMovies()

}