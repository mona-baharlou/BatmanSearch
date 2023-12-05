package com.mona.batmansearch.data.network.api

import com.mona.batmansearch.BuildConfig
import com.mona.batmansearch.data.network.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET
    suspend fun searchMovie(
        @Query("ca&s") ca: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("api_key") apiKey: String = BuildConfig.OMDB_API_KEY
    ): SearchResponse
}