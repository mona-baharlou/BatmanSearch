package com.mona.batmansearch.presentation.search.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.mona.batmansearch.R
import com.mona.batmansearch.data.model.searchItem.SearchItemsData
import com.mona.batmansearch.presentation.ui.theme.BatmanSearchTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import org.jetbrains.annotations.VisibleForTesting

@VisibleForTesting
const val SEARCH_TEXT_FIELD = "SEARCH_TEXT_FIELD"

@VisibleForTesting
const val SEARCH_BUTTON = "SEARCH_BUTTON"

@OptIn(ExperimentalComposeUiApi::class)
@Composable
internal fun SearchScreen(
    searchData: Flow<PagingData<SearchItemsData.SearchItemData>>,
    onSearchClick: (query: String) -> Unit,
    onItemClick: (itemData: SearchItemsData.SearchItemData) -> Unit,
    initialEmptyState: Boolean = true
) {

    var text by rememberSaveable { mutableStateOf("") }
    var emptyState by rememberSaveable { mutableStateOf(initialEmptyState) }

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val onSearch: () -> Unit = {
        keyboardController?.hide()
        focusManager.clearFocus()
        if (text.isNotEmpty()) {
            emptyState = false
            onSearchClick.invoke(text.trim())
            scope.launch {
                listState.animateScrollToItem(0)
            }
        }
    }

    val keyboardActions = KeyboardActions(
        onDone = {
            onSearch.invoke()
        }
    )


    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = {
                    text = it
                },
                modifier = Modifier
                    .padding(end = 16.dp)
                    .weight(1f)
                    .testTag(SEARCH_TEXT_FIELD),
                label = {
                    Text(stringResource(R.string.search))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = keyboardActions,
                maxLines = 1
            )
            Button(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .testTag(SEARCH_BUTTON),
                onClick = onSearch
            ) {
                Text(
                    text = stringResource(R.string.search),
                    maxLines = 1
                )
            }
        }
        Divider(color = Color.LightGray)

        if (emptyState) {
            Box(modifier = Modifier.fillMaxSize())
        } else {
            val lazyItems = searchData.collectAsLazyPagingItems()

            LazyColumn(content = {
                items(lazyItems.itemCount) { index ->
                    lazyItems[index]?.let {
                        ListItem(it) { itemData ->
                            onItemClick(itemData)
                        }
                        Divider(color = Color.LightGray)
                    }
                }


                lazyItems.apply {
                    when {
                        loadState.refresh is LoadState.Loading -> {
                            //item(LoadingItem())
                        }

                        loadState.append is LoadState.Loading -> {
//item(LoadingItem())
                        }

                        loadState.refresh is LoadState.Error -> {
//item(ErrorItem())
                        }

                        loadState.append is LoadState.Error -> {
//item(ErrorItem())
                        }
                    }
                }
            })
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun SearchPreview() {
    BatmanSearchTheme {
        SearchScreen(
            searchData = flow {
                emit(PagingData.from(ListItemSample))
            },
            onSearchClick = {},
            onItemClick = {},
            initialEmptyState = false
        )
    }
}
