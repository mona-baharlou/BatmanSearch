package com.mona.batmansearch.domain.usecase

import androidx.lifecycle.LiveData
import com.mona.batmansearch.data.network.model.detail.ItemDetail
import com.mona.batmansearch.data.repository.DetailRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@ViewModelScoped
class GetDetailUseCase @Inject constructor(
    private val repository: DetailRepository
) {
    suspend fun execute(query: String): ItemDetail {
        return repository.getItemDetail(query)
    }
}
