package com.abrsoftware.data.model

import com.google.gson.annotations.SerializedName
/*Object that work with Retrofit*/
data class MovieModel(
    @SerializedName("movieId") val movieId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("release_date") val release_date: String,
    @SerializedName("poster_path") val poster_path: String,
    @SerializedName("overview") val overview: String,
)
