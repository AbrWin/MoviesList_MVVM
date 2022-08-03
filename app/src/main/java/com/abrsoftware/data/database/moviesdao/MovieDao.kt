package com.abrsoftware.data.database.moviesdao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abrsoftware.data.database.entities.MovieEntity

@Dao
interface MovieDao {
    @Query("Select * from movies_table ORDER BY title DESC")
    suspend fun getAllMovies(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)
}