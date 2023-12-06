package com.mona.batmansearch.presentation.detail.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mona.batmansearch.data.model.searchItem.SearchItemsData
import com.mona.batmansearch.data.network.model.detail.ItemDetail
import com.mona.batmansearch.domain.usecase.GetDetailUseCase
import com.mona.batmansearch.presentation.detail.navigation.NAV_ARG_DATA
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


data class DetailViewState(
    val itemData: SearchItemsData.SearchItemData = SearchItemsData.SearchItemData()
)

data class ItemViewState(
    val itemDetail: ItemDetail = ItemDetail()
)

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getDetailUseCase: GetDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val viewState = mutableStateOf(DetailViewState())

    val detail = mutableStateOf(ItemViewState())

    init {
        savedStateHandle.get<SearchItemsData.SearchItemData>(NAV_ARG_DATA)?.let {
            viewState.value = viewState.value.copy(itemData = it)
        }
    }


    fun callDetail(query: String) {
        viewModelScope.launch {
            getDetail(query)
        }
    }

    private suspend fun getDetail(query: String) {

        viewModelScope.launch {
            try {
                val response = getDetailUseCase.execute(query)
                detail.value = detail.value.copy(response)

            } catch (e: Exception) {

            }

        }
    }

}