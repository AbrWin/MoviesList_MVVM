package com.abrsoftware.data.database

import androidx.room.*
import com.abrsoftware.data.database.entities.MovieEntity
import com.abrsoftware.data.database.moviesdao.MovieDao

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun getMovieDao():MovieDao
}