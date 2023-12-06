package com.mona.batmansearch.presentation.detail.navigation

import android.net.Uri
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.mona.batmansearch.data.model.searchItem.SearchItemsData


internal const val detailRoute = "detail_route"
const val NAV_ARG_DATA = "data"
fun NavController.navigateToDetail(
    itemData: SearchItemsData.SearchItemData
) {

    val data = Uri.encode(Gson().toJson(itemData))
    navigate("${detailRoute}/${data}")
}

fun NavGraphBuilder.detailScreen() {
    composable(
        route = "$detailRoute/{$NAV_ARG_DATA}",
        arguments = listOf(
            navArgument(NAV_ARG_DATA) {
//type =params
            }
        )
    )
}