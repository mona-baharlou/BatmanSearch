package com.mona.batmansearch.data.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.mona.batmansearch.data.network.api.SearchApi
import com.mona.batmansearch.data.repository.DetailRepository
import com.mona.batmansearch.data.repository.SearchRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

private const val BASE_URL = "https://www.omdbapi.com/"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Singleton
    @Provides
    fun provideOkHttpClient() =
        OkHttpClient
            .Builder()
            .addInterceptor(
                HttpLoggingInterceptor().also {
                    it.setLevel(HttpLoggingInterceptor.Level.BODY)
                }
            )
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, json: Json): Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideSearchApi(retrofit: Retrofit): SearchApi = retrofit.create(SearchApi::class.java)

    @Provides
    @Singleton
    fun provideSearchRepository(searchApi: SearchApi): SearchRepository =
        SearchRepository(searchApi)

    @Provides
    @Singleton
    fun provideDetailRepository(searchApi: SearchApi): DetailRepository =
        DetailRepository(searchApi)
}