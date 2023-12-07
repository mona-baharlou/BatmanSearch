package com.mona.batmansearch.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey val id: Int,
    val poster: String,
    val title: String?,
    val type: String?,
    val year: String?,
    val imdbID: String
)
