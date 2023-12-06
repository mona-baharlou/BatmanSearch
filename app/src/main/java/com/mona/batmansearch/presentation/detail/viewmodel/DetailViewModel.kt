package com.mona.batmansearch.presentation.detail.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mona.batmansearch.data.model.searchItem.SearchItemsData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


data class DetailViewState(
    val itemData: SearchItemsData.SearchItemData = SearchItemsData.SearchItemData()
)

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val viewState = mutableStateOf(DetailViewState())

    init {
//savedStateHandle.get<SearchItemsData.SearchItemData>()
    }
}