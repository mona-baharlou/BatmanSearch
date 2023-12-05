package com.mona.batmansearch.data.model.SearchItem

data class SearchedItemData(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)