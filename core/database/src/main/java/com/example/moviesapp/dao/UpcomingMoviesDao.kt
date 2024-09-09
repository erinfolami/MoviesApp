package com.example.moviesapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.moviesapp.model.UpcomingMoviesEntity

/**
 * DAO for  [UpcomingMoviesEntity] access
 */

@Dao
interface UpcomingMoviesDao {
    @Transaction
    @Query(
        value = """
            SELECT * FROM upcoming_movies
            """)
    suspend fun getAllUpcomingMovies(): List<UpcomingMoviesEntity>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<UpcomingMoviesEntity>)


    @Query(
        value = """
            DELETE FROM upcoming_movies
            """)
    suspend fun clearAll()
}