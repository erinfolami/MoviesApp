package com.example.moviesapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.moviesapp.model.TrendingMoviesEntity

/**
 * DAO for  [TrendingMoviesEntity] access
 */

@Dao
interface TrendingMoviesDao {
    @Transaction
    @Query(
        value = """
            SELECT * FROM trending_movies
            """)
    suspend fun getAllTrendingMovies(): List<TrendingMoviesEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<TrendingMoviesEntity>)


    @Query(
        value = """
            DELETE FROM trending_movies
            """)
    suspend fun clearAll()
}