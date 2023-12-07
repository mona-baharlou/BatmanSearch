package com.mona.batmansearch.presentation.detail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mona.batmansearch.R
import com.mona.batmansearch.data.model.searchItem.SearchItemsData
import com.mona.batmansearch.data.network.model.detail.ItemDetail
import com.mona.batmansearch.presentation.detail.viewmodel.DetailViewModel
import com.mona.batmansearch.presentation.detail.viewmodel.DetailViewState
import com.mona.batmansearch.presentation.detail.viewmodel.ItemViewState
import com.mona.batmansearch.presentation.search.ui.ErrorItem
import com.mona.batmansearch.presentation.search.ui.ListItem
import com.mona.batmansearch.presentation.search.ui.LoadingItem
import com.mona.batmansearch.presentation.ui.theme.green
import dagger.hilt.android.lifecycle.HiltViewModel


@Composable
internal fun DetailRoute(
    viewModel: DetailViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState
    val itemState by viewModel.detail

    DetailScreen(viewState = viewState, itemState)
}

@Composable
internal fun DetailScreen(
    viewState: DetailViewState,
    itemState: ItemViewState
) {
    val viewModel: DetailViewModel = hiltViewModel()
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
            //maxLines = 1,
            text = viewState.itemData.title,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        Divider(color = Color.LightGray ,
            modifier = Modifier.padding(start = 22.dp, end = 22.dp))



        ImdbSection(itemState)

        PlotSection(itemState)

    }




    //val lazyItems = searchData.collectAsLazyPagingItems()

    /*LazyColumn(content = {

    })*/


}

@Composable
private fun ImdbSection(itemState: ItemViewState) {
    Row(
        modifier = Modifier.padding(start = 8.dp , end = 8.dp),//.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(R.string.imdb),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(14.dp)
                .wrapContentSize(),
            fontWeight = FontWeight.Bold,
            color = Color.Gray

        )
        Text(
            text = itemState.itemDetail.imdbRating,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(14.dp)
                .wrapContentSize(),
            fontWeight = FontWeight.Bold,
            //color = Color.Gray

        )

        Text(
            stringResource(R.string.genre),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(14.dp)
                .wrapContentSize(),
            fontWeight = FontWeight.Bold,
            color = Color.Gray

        )

        Text(
            text = itemState.itemDetail.Genre ?: "",
            maxLines =1,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(12.dp),
            fontWeight = FontWeight.Bold,
           // color = Color.Gray

        )

    }
}

@Composable
private fun GenreSection(itemState: ItemViewState) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            stringResource(R.string.genre),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(14.dp)
                .wrapContentSize(),
            fontWeight = FontWeight.Bold,
            color = Color.Gray

        )

        Text(
            text = itemState.itemDetail.Genre ?: "",
            maxLines = 1,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(12.dp),
            fontWeight = FontWeight.Bold,
            color = Color.Gray

        )

    }
}

@Composable
private fun PlotSection(itemState: ItemViewState) {
    Row(
        modifier = Modifier.fillMaxSize(),
      //  horizontalArrangement = Arrangement.SpaceBetween
    ) {

       /* Text(
            text = stringResource(R.string.plot),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(14.dp)
                .wrapContentSize(),
            fontWeight = FontWeight.Bold,
            color = Color.Gray

        )*/

        Text(
            text = itemState.itemDetail.Plot ?: "",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(15.dp),
            fontWeight = FontWeight.Bold,
           // color = Color.Gray

        )

    }
}

/*@Preview(showBackground = true)
@Composable
private fun DetailPreview() {
    DetailScreen(
        viewState = DetailViewState(SearchItemsData.SearchItemData(title = "Batman")),
        itemState = ItemViewState(ItemDetail(Genre = "Super Hero", imdbRating = "4.5"))
    )
}*/
