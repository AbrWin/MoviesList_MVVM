package com.abrsoftware.data.network

import com.abrsoftware.data.model.MovieModel
import com.abrsoftware.data.model.MoviePopularResponce
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiClient {
    @GET(Routes.LASTEST)
    suspend fun getLastest(
        @Path("page") nMovie: String?,
        @Query("api_key") api_key: String?
    ):  Response<MoviePopularResponce>

    @GET(Routes.POPULAR)
    suspend fun getPopular(
        @Path("page") nMovie: String?,
        @Query("api_key") api_key: String?
    ): Response<List<MovieModel>>

    @GET(Routes.UPCOMING)
    suspend fun getUpcoming(
        @Path("page") nMovie: String?,
        @Query("api_key") api_key: String?
    ): Response<List<MovieModel>>
}