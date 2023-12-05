package com.mona.batmansearch.domain.repository

import com.mona.batmansearch.data.network.model.Search

interface SearchRepository {
    suspend fun search(query: String, currentPage: Int): Search
}