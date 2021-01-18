package com.survivalcoding.ifkakao.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class ConferenceRepositoryTest {
    private val repository = ConferenceRepository()

    @Test
    fun initializationTest() {
        assertNotNull(repository)
    }

    @Test
    fun getConferenceData() {
        val conferenceData = repository.getConferenceData()
        assertNotNull(conferenceData)

        assertEquals(8, conferenceData.size)
    }

    @Test
    fun checkConferenceData() {
        val conferenceData = repository.getConferenceData()

        conferenceData[0].let {
            assertEquals("SwiftLeeds", it.name)
            assertEquals("2020-10-08", it.end)
            assertEquals(null, it.cocoaOnly)
        }

        conferenceData[4].let {
            assertEquals("https://www.tryswift.co/events/2020/tokyo/en/", it.link)
            assertEquals("2020-03-18", it.start)
            assertEquals(null, it.cocoaOnly)
        }

        conferenceData[7].let {
            assertEquals("MobileOptimized 2019", it.name)
            assertEquals(false, it.cocoaOnly)
        }
    }
}