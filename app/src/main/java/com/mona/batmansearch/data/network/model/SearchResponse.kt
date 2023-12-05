package com.mona.batmansearch.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    val search: List<Search>,
    val totalResults: Int,
    val response: String,


)



/*@Serializable
data class Items(
    val page: Int,
    val item: List<Item>
)*/

@Serializable
data class Search(
    val id: Int,
    val poster: String?,
    val title: String,
    val type: String?,
    val year: String?,
    val imdbID: String?

)