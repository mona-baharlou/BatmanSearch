package com.mona.batmansearch.data.repository

import com.mona.batmansearch.data.network.api.SearchApi
import com.mona.batmansearch.data.network.model.SearchResponse

class FakeSearchApi(private val response: SearchResponse) : SearchApi {
    override suspend fun searchMovie(
        ca: String,
        page: Int,
        perPage: Int,
        apiKey: String
    ): SearchResponse = response
}