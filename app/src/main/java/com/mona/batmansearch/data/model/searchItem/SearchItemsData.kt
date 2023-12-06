package com.mona.batmansearch.data.model.searchItem

import android.os.Parcelable
import com.mona.batmansearch.data.network.model.SearchItem
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


data class SearchItemsData(
    val searchItems: List<SearchItemData> = emptyList()
) {
    @Parcelize
    @Serializable
    data class SearchItemData(
        val poster: String = "",
        val title: String = "",
        val type: String = "",
        val year: String = "",
        val imdbID: String = ""
    ) : Parcelable


}

internal fun SearchItem.asModel(): SearchItemsData.SearchItemData = SearchItemsData.SearchItemData(
    title = Title,
    poster = Poster,
    year = Year,
    imdbID = imdbID,
    type = Type
)
