package com.example.ifkakao.model

import com.example.ifkakao.model.jsonformat.ConferenceData
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import org.junit.Test

class RemoteDataSourceTest {
    @Test
    fun remoteDataTest() {
        val remote = RemoteDataSource()
        var resultData: ConferenceData? = null
        remote.getConferenceData {
            resultData = it
        }
        Thread.sleep(500)
        assertNotNull(resultData)
        assertTrue(resultData!!.success)
    }
}