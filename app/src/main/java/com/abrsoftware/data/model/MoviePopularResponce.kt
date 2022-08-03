package com.abrsoftware.data.model

import com.google.gson.annotations.SerializedName

data class MoviePopularResponce(
    @SerializedName("results") val results: List<MovieModel>
)
