package com.survivalcoding.ifkakao.first.model.repository

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ConferenceRepositoryTest {

    private val repository = ConferenceRepository()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getData() {
        assertEquals(8, repository.getData().size)
        assertNull(repository.getData()[0].cocoaOnly)
        assertNotNull(repository.getData()[7].cocoaOnly)
    }
}