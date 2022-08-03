package com.abrsoftware.data

import com.abrsoftware.data.model.MovieModel
import com.abrsoftware.data.model.MovieProvider
import com.abrsoftware.data.network.MovieService
import javax.inject.Inject


class MovieRepository @Inject constructor(
    private val api: MovieService,
    private val movieProvider: MovieProvider
){
    suspend fun getAllLastest(): List<MovieModel>{
        val response = api.getLastestMovies()
        movieProvider.movies = response
        return response
    }
}