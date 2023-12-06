package com.mona.batmansearch.presentation.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mona.batmansearch.data.model.searchItem.SearchItemsData
import com.mona.batmansearch.presentation.search.ui.SearchRoute


internal const val searchRoute = "search_route"

fun NavGraphBuilder.searchScreen(
    onItemClick: (itemData: SearchItemsData.SearchItemData) -> Unit
) {
    composable(
        route = searchRoute
    ) {
        SearchRoute(onItemClick = onItemClick)
    }
}