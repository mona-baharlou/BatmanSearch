package com.mona.batmansearch.domain.usecase

import androidx.paging.PagingData
import com.mona.batmansearch.data.model.searchItem.SearchItemsData
import com.mona.batmansearch.data.repository.SearchRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@ViewModelScoped
class GetSearchUseCase @Inject constructor(
    private val repository: SearchRepository
) {
    suspend fun execute(query: String): Flow<PagingData<SearchItemsData.SearchItemData>> {
        return repository.getSearchItems(query)
    }
}
