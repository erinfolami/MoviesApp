package com.example.moviesapp.data.repository.local

import com.example.moviesapp.dao.TrendingMoviesDao
import com.example.moviesapp.model.TrendingMoviesEntity
import javax.inject.Inject

class LocalMoviesAppRepositoryImpl @Inject constructor(
    private val trendingMoviesDao : TrendingMoviesDao
) : LocalMoviesAppRepository {
    override suspend fun getAllTrendingMovies(): List<TrendingMoviesEntity> =
        trendingMoviesDao.getAllTrendingMovies()


    override suspend fun insertAll(movies: List<TrendingMoviesEntity>) {
        trendingMoviesDao.insertAll(movies)
    }

    override suspend fun clearAll() {
      trendingMoviesDao.clearAll()
    }
}