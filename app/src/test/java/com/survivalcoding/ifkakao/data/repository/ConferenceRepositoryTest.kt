package com.survivalcoding.ifkakao.data.repository

import com.survivalcoding.ifkakao.data.viewmodel.ConferenceViewModel
import com.survivalcoding.ifkakao.view.main.model.Conference
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ConferenceRepositoryTest {
    private val repository = ConferenceRepository()
    private val viewModel = ConferenceViewModel(repository)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getItems() {
        with(repository.getItems()) {
            assertEquals(8, size)
            assertEquals(
                Conference(
                    name = "SwiftLeeds",
                    link = "https://swiftleeds.co.uk/",
                    start = "2020-10-07",
                    end = "2020-10-08",
                    location = "🇬🇧 Leeds, UK"
                ), this[0]
            )
        }
    }

    @Test
    fun getItemsEqualsInViewModel() {
        assertEquals(repository.getItems(), viewModel.getItems())
    }
}