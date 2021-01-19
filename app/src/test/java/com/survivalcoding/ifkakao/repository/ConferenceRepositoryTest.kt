package com.survivalcoding.ifkakao.repository

import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class ConferenceRepositoryTest {

    val repository = ConferenceRepository()
    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }
    @Test
    fun getConferenceList() {
        assertEquals(8, repository.getConferenceList().size)
    }
    @Test
    fun getRequest(){
        assertNotEquals(0, repository.getRequests().size)
    }
}