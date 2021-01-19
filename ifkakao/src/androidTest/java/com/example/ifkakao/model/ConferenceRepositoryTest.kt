package com.example.ifkakao.model

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.ifkakao.R
import com.example.ifkakao.util.readTextFile
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class ConferenceRepositoryTest {
    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val dummyData = readTextFile(context, R.raw.dummydata)
    private val repository = ConferenceRepository(dummyData)
    private val conferenceData = repository.getConferenceData()

    @Test
    fun readDummyDataTest() {
        assertNotNull(dummyData)
    }

    @Test
    fun repositoryInitTest() {
        assertNotNull(repository)
    }

    @Test
    fun conferenceDataTest() {
        assertNotNull(conferenceData)
        assertEquals(true, conferenceData.success)
        assertEquals(54, conferenceData.data.size)
    }

    @Test
    fun conferenceValueTest() {
        with(conferenceData.data) {
            get(0).let {
                assertEquals("카카오", it.companyName)
                assertEquals("오프닝 키노트", it.title)
            }
            get(1).let {
                assertEquals(7, it.idx)
                assertEquals(
                    "#카카오톡 #신규서비스 #톡서랍 #팀채팅 #멀티프로필 #인물검색 #디지털신분증 #카카오인증서 #디지털자산",
                    it.contentTag
                )
            }
            get(38).let {
                assertEquals(121, it.idx)
                assertEquals(121, it.linkList.video[0].contentsIdx)
                assertEquals("권성원_공동체데이터센터_1 (nathan.png", it.linkList.speakerProfile[0].description)
            }
            get(53).let {
                assertEquals("톡에서 발견하는 신규 고객, <br>카카오 X 정육각", it.title)
                assertEquals("2020-11-17 08:47:26", it.lastModifiedDateTime)
            }
        }
    }
}