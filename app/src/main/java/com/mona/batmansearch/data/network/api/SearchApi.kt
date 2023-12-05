package com.mona.batmansearch.data.network.api

import com.mona.batmansearch.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET
    suspend fun searchMovie(
        @Query("ca&s") ca: String,
        @Query("api_key") apiKey: String = BuildConfig.OMDB_API_KEY
    )
}