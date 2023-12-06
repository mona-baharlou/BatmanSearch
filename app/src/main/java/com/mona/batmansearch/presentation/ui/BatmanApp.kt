package com.mona.batmansearch.presentation.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.mona.batmansearch.R
import com.mona.batmansearch.presentation.navigation.BatmanNavHost


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BatmanApp() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.displaySmall
                    )
                }
            )
        }
    ) { innerPadding ->
        BatmanNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
