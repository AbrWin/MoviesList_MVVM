package com.abrsoftware.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*Object that work with Room*/
@Entity(tableName = "movies_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "movieId") val movieId: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "release_date") val release_date: String,
    @ColumnInfo(name = "poster_path") val poster_path: String,
    @ColumnInfo(name = "overview") val overview: String,
    @ColumnInfo(name = "type") val type: String
)
