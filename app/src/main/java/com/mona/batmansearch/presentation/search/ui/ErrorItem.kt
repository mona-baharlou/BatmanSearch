package com.mona.batmansearch.presentation.search.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mona.batmansearch.R
import com.mona.batmansearch.presentation.ui.theme.BatmanSearchTheme

@Composable
internal fun ErrorItem() {
    Box(
        modifier = Modifier
            .testTag("ProgressBarItem")
            .fillMaxWidth()
            .height(106.dp)
            .wrapContentWidth(
                Alignment.CenterHorizontally
            )
    ) {
        Text(text = stringResource(id = R.string.something_went_wrong))
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewErrorItem() {
    BatmanSearchTheme {
        ErrorItem()
    }
}