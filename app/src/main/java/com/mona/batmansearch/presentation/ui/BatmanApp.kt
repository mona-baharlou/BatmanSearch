package com.mona.batmansearch.presentation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mona.batmansearch.R
import com.mona.batmansearch.presentation.detail.navigation.detailRoute
import com.mona.batmansearch.presentation.navigation.BatmanNavHost
import com.mona.batmansearch.presentation.search.navigation.searchRoute


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BatmanApp() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val topBarState = rememberSaveable { (mutableStateOf(true)) }

    // Control TopBar
    /* when (navBackStackEntry?.destination?.route) {
         searchRoute -> {
             topBarState.value = true
         }

         detailRoute -> {
             // TopBar
             topBarState.value = false
         }
     }*/

    Scaffold(
        topBar = {
            TopBar(

                navController = navController,
                topBarState = topBarState

            )
        }


    ) { innerPadding ->
        BatmanNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding),

            )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController, topBarState: MutableState<Boolean>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val title: String = when (navBackStackEntry?.destination?.route ?: searchRoute) {
        searchRoute -> "Movies"
        else -> ""
    }

    AnimatedVisibility(
        visible = topBarState.value,
        enter = slideInVertically(initialOffsetY = { -it }),
        exit = slideOutVertically(targetOffsetY = { -it }),
        content = {
            TopAppBar(
                title = { Text(text = title) },
            )
        }
    )
}