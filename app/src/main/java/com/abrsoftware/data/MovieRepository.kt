package com.abrsoftware.data

import com.abrsoftware.data.database.entities.MovieEntity
import com.abrsoftware.data.database.moviesdao.MovieDao
import com.abrsoftware.data.model.MovieModel
import com.abrsoftware.data.model.MovieProvider
import com.abrsoftware.data.network.MovieService
import com.abrsoftware.domain.model.Movie
import com.abrsoftware.domain.model.toDomain
import javax.inject.Inject


class MovieRepository @Inject constructor(
    private val api: MovieService,
    private val movieDao: MovieDao
){
    suspend fun getAllLastestFromApi(): List<Movie>{
        val response:List<MovieModel> = api.getLastestMovies()
        return response.map { it.toDomain() }
    }

    suspend fun getAllLastestFromDb():List<Movie>{
        val response:List<MovieEntity> = movieDao.getAllMovies()
        return response.map { it.toDomain() }
    }

    suspend fun insertMovies(movies: List<MovieEntity>){
        movieDao.insertMovies(movies)
    }

    suspend fun clearMovies(){
        movieDao.deleteAllMovies()
    }
}