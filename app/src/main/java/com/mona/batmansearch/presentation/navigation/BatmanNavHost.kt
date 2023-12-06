package com.mona.batmansearch.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.mona.batmansearch.presentation.search.navigation.searchRoute
import com.mona.batmansearch.presentation.search.navigation.searchScreen
import com.mona.batmansearch.presentation.search.ui.SearchRoute

@Composable
fun BatmanNavHost(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = searchRoute,
        modifier = modifier
    ) {
        /*searchScreen(
            onItemClick = navController::navigateToDetail
        )

        detailScreen()*/
    }
}
