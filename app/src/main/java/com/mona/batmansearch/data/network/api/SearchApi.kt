package com.mona.batmansearch.data.network.api

import com.mona.batmansearch.BuildConfig
import com.mona.batmansearch.data.network.model.detail.ItemDetail
import com.mona.batmansearch.data.network.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("/")
    suspend fun searchMovie(
        @Query("s") s: String,
        @Query("page") page: Int,
        @Query("apikey") apiKey: String = BuildConfig.OMDB_API_KEY
    ): SearchResponse

    @GET("/")
    suspend fun getDetail(
        @Query("i") s: String,
        @Query("apikey") apiKey: String = BuildConfig.OMDB_API_KEY
    ): ItemDetail

}