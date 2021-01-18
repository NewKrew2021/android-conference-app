package com.survivalcoding.ifkakao.confpractice

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

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
        assertEquals("SwiftLeeds", repository.getData()[0].name)
    }
}