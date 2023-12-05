package com.mona.batmansearch.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mona.batmansearch.presentation.consts.Consts.Companion.PER_PAGE
import com.mona.batmansearch.data.SearchDataSource
import com.mona.batmansearch.data.model.searchItem.SearchItemsData
import com.mona.batmansearch.data.network.api.SearchApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton


@Singleton
class SearchRepository(
    private val searchApi: SearchApi,
) {
    suspend fun getSearchItems(query: String): Flow<PagingData<SearchItemsData.SearchItemData>> {
        return Pager(
            config = PagingConfig(pageSize = PER_PAGE, prefetchDistance = 2),
            pagingSourceFactory = {
                SearchDataSource(query, searchApi)
            }
        ).flow
    }
}
