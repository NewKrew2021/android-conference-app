package com.survivalcoding.ifkakao.first.model.repository

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
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
        val data = repository.getData()

        assertEquals(8, data.size)
        data[0].let {
            assertEquals("SwiftLeeds", it.name)
            assertEquals("https://swiftleeds.co.uk/", it.link)
            assertEquals("2020-10-07", it.start)
            assertEquals("2020-10-08", it.end)
            assertEquals("🇬🇧 Leeds, UK", it.location)
            assertNull(it.cocoaOnly)
        }

        data[7].let {
            assertEquals("MobileOptimized 2019", it.name)
            assertEquals("https://moconf.by/", it.link)
            assertEquals("2019-10-19", it.start)
            assertEquals("2019-10-19", it.end)
            assertEquals("🇧🇾 Minsk, Belarus", it.location)
            assertEquals(false, it.cocoaOnly)
        }
    }
}