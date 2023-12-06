package com.mona.batmansearch.data.repository

import androidx.lifecycle.LiveData
import com.mona.batmansearch.data.network.api.SearchApi
import com.mona.batmansearch.data.network.model.detail.ItemDetail
import javax.inject.Singleton


@Singleton
class DetailRepository(
    private val searchApi: SearchApi,
) {
    suspend fun getItemDetail(query: String): ItemDetail {
       return searchApi.getDetail(query)
    }
}
