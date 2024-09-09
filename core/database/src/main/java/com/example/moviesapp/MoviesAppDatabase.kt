package com.example.moviesapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapp.dao.TrendingMoviesDao
import com.example.moviesapp.dao.UpcomingMoviesDao
import com.example.moviesapp.model.TrendingMoviesEntity
import com.example.moviesapp.model.UpcomingMoviesEntity

@Database(entities = [TrendingMoviesEntity::class, UpcomingMoviesEntity::class], version = 1)
abstract class MoviesAppDatabase : RoomDatabase() {
    abstract fun trendingMoviesDao(): TrendingMoviesDao

    abstract fun upcomingMoviesDao(): UpcomingMoviesDao
}