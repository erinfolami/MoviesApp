package com.example.moviesapp.di

import com.example.moviesapp.MoviesAppDatabase
import com.example.moviesapp.dao.TrendingMoviesDao
import com.example.moviesapp.dao.UpcomingMoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

    @Provides
    fun provideTrendingMoviesDao(database: MoviesAppDatabase)
    : TrendingMoviesDao = database.trendingMoviesDao()

    @Provides
    fun provideUpcomingMoviesDao(database: MoviesAppDatabase)
    : UpcomingMoviesDao = database.upcomingMoviesDao()
    
}