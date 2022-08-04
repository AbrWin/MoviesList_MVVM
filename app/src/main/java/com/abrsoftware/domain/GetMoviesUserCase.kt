package com.abrsoftware.domain

import com.abrsoftware.data.MovieRepository
import com.abrsoftware.data.database.entities.toDatabase
import com.abrsoftware.domain.model.Movie
import javax.inject.Inject

class GetMoviesUserCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(): List<Movie> {
        val movies = repository.getAllLastestFromApi()
        return if (movies.isNotEmpty()) {
            repository.clearMovies()
            repository.insertMovies(movies.map { it.toDatabase() })
            movies
        } else {
            repository.getAllLastestFromDb()
        }
    }
}