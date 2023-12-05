package com.mona.batmansearch.data.repository

import androidx.paging.filter
import com.mona.batmansearch.data.model.searchItem.SearchItemsData
import com.mona.batmansearch.data.network.api.SearchApi
import com.mona.batmansearch.data.network.model.Search
import com.mona.batmansearch.data.network.model.SearchResponse
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import kotlin.math.exp

class SearchRepositoryTest {

    private lateinit var repository: SearchRepository
    private lateinit var searchApi: SearchApi

    @Before
    fun setUp() {
        searchApi = mock(SearchApi::class.java)
        repository = SearchRepository(searchApi)
    }

    @Test
    fun `search should return movies from search api`() = runBlocking {
        val expectedMovie = SearchResponse(
            search = listOf(
                Search(
                    id = 1,
                    title = "title",
                    poster = "1.jpg",
                    year = "2008",
                    imdbID = "imdbID",
                    type = "movie"
                )
            ), totalResults = 0, response = "true"
        )

        `when`(searchApi.searchMovie(ca = "test", page = 1, perPage = 10)).thenReturn(
            expectedMovie
        )

        val result = repository.getSearchItems("test")

        //assert
        //assertEquals(expectedMovie.search, )

        // TODO Fix test

    }

}