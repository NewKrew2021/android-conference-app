package com.survivalcoding.ifkakao.repository

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class ConferenceRepositoryTest {

    val repository = TmpConferenceRepository()
    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getDataJson() {
        assertEquals(7,repository.getData().size)
    }
}