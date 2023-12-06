package com.mona.batmansearch.data.network.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    val Search: List<SearchItem>,
    val totalResults: Int,
    val Response: String
)

@Serializable
data class SearchItem(
    //val id: Int,
    val Poster: String,
    val Title: String,
    val Type: String,
    val Year: String,
    val imdbID: String

)