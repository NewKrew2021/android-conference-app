package com.survivalcoding.ifkakao.data.repository

import org.junit.After
import org.junit.Assert.assertEquals
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
    fun getConferenceResponse() {
        assertEquals(28, repository.getConferenceResponse()[0].idx)
    }
}