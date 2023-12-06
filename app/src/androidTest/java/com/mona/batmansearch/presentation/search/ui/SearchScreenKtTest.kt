package com.mona.batmansearch.presentation.search.ui

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.paging.PagingData
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.flow
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SearchScreenKtTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun list_items_loaded() {
        //Given
        composeTestRule.setContent {
            SearchScreen(
                searchData =
                flow { emit(PagingData.from(ListItemSample)) },
                onSearchClick = {},
                onItemClick = {},
                initialEmptyState = false
            )
        }

        //When, Then
        composeTestRule
            .onNodeWithText(ListItemSample.first().title)
            .assertIsDisplayed()
    }


}