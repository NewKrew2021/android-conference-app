package com.survivalcoding.ifkakao

import com.survivalcoding.ifkakao.repository.ConferenceRepository
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test

class ApiExampleTest {

    private val repository = ConferenceRepository()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getData() {
        assertEquals(repository.getConferences().size, 8)
    }
}