package com.abrsoftware.domain

import com.abrsoftware.data.MovieRepository
import javax.inject.Inject

class GetMoviesUserCase @Inject constructor(private val repository: MovieRepository){
    suspend operator fun invoke() = repository.getAllLastest()
}