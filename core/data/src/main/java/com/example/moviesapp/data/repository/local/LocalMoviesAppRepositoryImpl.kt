package com.example.moviesapp.data.repository.local

import com.example.moviesapp.dao.TrendingMoviesDao
import com.example.moviesapp.dao.UpcomingMoviesDao
import com.example.moviesapp.model.TrendingMoviesEntity
import com.example.moviesapp.model.UpcomingMoviesEntity
import javax.inject.Inject

class LocalMoviesAppRepositoryImpl @Inject constructor(
    private val trendingMoviesDao : TrendingMoviesDao,
    private val upcomingMoviesDao : UpcomingMoviesDao
) : LocalMoviesAppRepository {
    override suspend fun getAllTrendingMovies(): List<TrendingMoviesEntity> =
        trendingMoviesDao.getAllTrendingMovies()


    override suspend fun insertAllTrendingMovies(movies: List<TrendingMoviesEntity>) {
        trendingMoviesDao.insertAll(movies)
    }

    override suspend fun clearAllTrendingMovies() {
      trendingMoviesDao.clearAll()
    }

    override suspend fun getAllUpcomingMovies(): List<UpcomingMoviesEntity> =
        upcomingMoviesDao.getAllUpcomingMovies()

    override suspend fun insertAllUpcomingMovies(movies: List<UpcomingMoviesEntity>) {
        upcomingMoviesDao.insertAll(movies)
    }

    override suspend fun clearAllUpcomingMovies() {
        upcomingMoviesDao.clearAll()
    }
}