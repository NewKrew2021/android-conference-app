package com.example.ifkakao.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class ConferenceRepositoryTest {
    private val repository = ConferenceRepository()

    @Test
    fun loadDataTest() {
        assertNotNull(repository)
        val conferenceData = repository.getConferenceData()
        assertNotNull(conferenceData)
        assertEquals(true, conferenceData.success)
    }

    @Test
    fun conferenceDataTest() {
        val conferenceData = repository.getConferenceData()
        assertEquals(9, conferenceData.data.size)

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
            get(4).let {
                assertEquals(31, it.idx)
                assertEquals(
                    "혁신의 씨앗을 뿌리는 카카오임팩트의 새로운 시작!\n" +
                            "2021년 1월, 우리 사회의 긍정적 변화를 만드는 사회혁신가들을 지원하는 '카카오임팩트펠로우십' 사업이 시작됩니다.\n" +
                            "\n" +
                            "더 나은 사회를 만드는 사람들, 가치있는 혁신을 고민하는 사람들의 발걸음이 꾸준히 나아가고, 그들의 목소리가 퍼질 수 있게 오늘보다 더 나은 미래를 만드는 사람들을 찾아내고 지원합니다. '카카오임팩트펠로우십'은 혁신가들에게 가장 필요한 부분을 지혜롭게 챙겨주고, 그들의 메시지를 확산해주고 연결하는 역할을 하고자 합니다.",
                    it.content
                )
                assertEquals(
                    "https://t1.kakaocdn.net/service_if_kakao_prod/file/file-1604391908664",
                    it.linkList.pcMainImage[0].url
                )

            }
            get(7).let {
                assertEquals(4, it.lastModifiedUserIdx)
                assertEquals("서비스", it.field)
                assertEquals("https://tv.kakao.com/embed/player/cliplink/414072195", it.linkList.video[0].url)
            }
        }
    }
}