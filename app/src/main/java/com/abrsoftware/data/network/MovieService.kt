package com.abrsoftware.data.network

import com.abrsoftware.data.model.MovieModel
import com.abrsoftware.data.model.MoviePopularResponce
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(
    private val api: MovieApiClient
) {
    suspend fun getLastestMovies():List<MovieModel>{
        return withContext(Dispatchers.IO){
            val response = api.getLastest("3","8ac3bea5e0e63f1b4c5f608d2f31b372")
            (response.body() as MoviePopularResponce).results
        }
    }
}