package com.mona.batmansearch.presentation.detail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mona.batmansearch.data.model.searchItem.SearchItemsData
import com.mona.batmansearch.data.network.model.detail.ItemDetail
import com.mona.batmansearch.presentation.detail.viewmodel.DetailViewModel
import com.mona.batmansearch.presentation.detail.viewmodel.DetailViewState
import com.mona.batmansearch.presentation.detail.viewmodel.ItemViewState
import com.mona.batmansearch.presentation.search.ui.ErrorItem
import com.mona.batmansearch.presentation.search.ui.ListItem
import com.mona.batmansearch.presentation.search.ui.LoadingItem
import dagger.hilt.android.lifecycle.HiltViewModel


@Composable
internal fun DetailRoute(
    viewModel: DetailViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState
    val itemState by viewModel.detail

    DetailScreen(viewState = viewState, viewModel, itemState)
}

@Composable
internal fun DetailScreen(
    viewState: DetailViewState,
    viewModel: DetailViewModel,
    itemState: ItemViewState
) {

    viewModel.callDetail(viewState.itemData.imdbID)

    Column {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .crossfade(true)
                .data(viewState.itemData.poster)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = Modifier
                .height(300.dp)
                .background(
                    Color.LightGray
                )

        )
        Text(
            text = viewState.itemData.title,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = itemState.itemDetail.Genre ?: "",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(12.dp)
        )

    }


    //val lazyItems = searchData.collectAsLazyPagingItems()

    /*LazyColumn(content = {

    })*/


}

@Preview(showBackground = true)
@Composable
private fun DetailPreview() {
    DetailScreen(
        viewState = DetailViewState(SearchItemsData.SearchItemData(title = "Batman")),
        viewModel = hiltViewModel(),
        itemState = ItemViewState(ItemDetail(Genre = "Super Hero"))
    )
}