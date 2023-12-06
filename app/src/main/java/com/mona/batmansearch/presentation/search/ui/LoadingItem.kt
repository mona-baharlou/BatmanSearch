package com.mona.batmansearch.presentation.search.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mona.batmansearch.presentation.ui.theme.BatmanSearchTheme

@Composable
internal fun LoadingItem() {

    CircularProgressIndicator(
        modifier = Modifier
            .testTag("ProgressBarItem")
            .fillMaxWidth()
            .padding(16.dp)
            .wrapContentWidth(
                Alignment.CenterHorizontally
            )
    )
}


@Preview(showBackground = true)
@Composable
private fun PreviewLoadingItem() {
    BatmanSearchTheme {
        LoadingItem()
    }
}