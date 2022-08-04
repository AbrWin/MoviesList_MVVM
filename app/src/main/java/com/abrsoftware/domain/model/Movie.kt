package com.abrsoftware.domain.model

import com.abrsoftware.data.database.entities.MovieEntity
import com.abrsoftware.data.model.MovieModel


data class Movie(
    val movieId: Int,
    val title: String,
    val release_date: String,
    val poster_path: String,
    val overview: String,
)

fun MovieModel.toDomain() = Movie(movieId, title, release_date,poster_path,overview)

fun MovieEntity.toDomain() = Movie(movieId, title, release_date,poster_path,overview)