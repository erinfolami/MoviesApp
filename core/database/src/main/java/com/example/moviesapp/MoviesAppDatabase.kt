package com.example.moviesapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviesapp.dao.TrendingMoviesDao
import com.example.moviesapp.model.TrendingMoviesEntity

@Database(entities = [TrendingMoviesEntity::class], version = 1)
abstract class MoviesAppDatabase : RoomDatabase() {
    abstract fun TrendingMoviesDao(): TrendingMoviesDao
}