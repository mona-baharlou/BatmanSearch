package com.mona.batmansearch.presentation.search.ui

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
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

    @Test
    fun list_item_isClicked() {

        //Given
        var verifyTitle: String? = null

        composeTestRule.setContent {

            SearchScreen(searchData = flow {
                emit(PagingData.from(ListItemSample))
            }, onSearchClick = {},
                onItemClick = {
                    verifyTitle = it.title
                },
                initialEmptyState = false
            )

        }

        //WHEN
        composeTestRule
            .onNodeWithText(ListItemSample.first().title)
            .performClick()

        //Then
        assert(ListItemSample.first().title == verifyTitle)
    }

    @Test
    fun search_isClicked() {
        // Given
        val searchQuery = "a query"
        var verifyQuery: String? = null

        composeTestRule.setContent {
            SearchScreen(
                searchData = flow {},
                onSearchClick = {
                    verifyQuery = it
                },
                onItemClick = {},
                initialEmptyState = false
            )
        }

        // When
        composeTestRule
            .onNodeWithTag(SEARCH_TEXT_FIELD)
            .performTextInput(searchQuery)

        composeTestRule
            .onNodeWithTag(SEARCH_BUTTON)
            .performClick()

        // Then
        assert(searchQuery == verifyQuery)
    }


}