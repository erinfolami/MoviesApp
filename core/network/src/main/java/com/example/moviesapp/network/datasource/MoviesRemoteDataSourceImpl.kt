package com.example.moviesapp.network.datasource

import com.example.moviesapp.network.model.SearchMoviesDTO
import com.example.moviesapp.network.model.TrendingMoviesDTO
import com.example.moviesapp.network.model.UpcomingMoviesDTO
import com.example.moviesapp.network.retrofit.MovieApiService
import retrofit2.Response
import javax.inject.Inject

class MoviesRemoteDataSourceImpl @Inject constructor(private val movieApiService: MovieApiService) :
    MoviesRemoteDataSource {
    override suspend fun getTrendingMovies(): Response<TrendingMoviesDTO> =
        movieApiService.getTrendingMovies()

    override suspend fun getUpcomingMovies(): Response<UpcomingMoviesDTO> =
        movieApiService.getUpcomingMovies()

    override suspend fun searchMovies(): Response<SearchMoviesDTO> =
        movieApiService.searchMovies()
}