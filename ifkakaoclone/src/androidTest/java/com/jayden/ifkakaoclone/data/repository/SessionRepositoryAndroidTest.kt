package com.jayden.ifkakaoclone.data.repository

import androidx.test.core.app.ApplicationProvider
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class SessionRepositoryAndroidTest {
    private val repository = SessionRepository(ApplicationProvider.getApplicationContext())

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getSessions() {
        with(repository.getSessions()) {
            assertEquals(54, size)

            this[0].let {
                assertEquals("오프닝 키노트", it.title)
                assertEquals(
                    """
                        if(kakao)2020은 더 나은 세상을 만들기 위한 카카오의 많은 생각과 도전들을 담았습니다.
                        오프닝키노트를 시작으로 11월 18일부터 3일 동안 다양한 카카오의 이야기가 펼쳐집니다. 
                        if(kakao)에서 카카오의 변화를 함께 확인해 보시죠!

                        오늘도 카카오는 일상을 바꾸는 중.
                    """.trimIndent(),
                    it.content
                )
                assertEquals("#ifkakao2020 #이프카카오2020 #카카오컨퍼런스", it.contentTag)
                assertEquals(
                    "https://tv.kakao.com/embed/player/cliplink/414004572",
                    it.linkList?.video?.get(0)?.url
                )
            }

            this[2].let {
                assertEquals("비즈니스. 톡처럼 쉬워지다.", it.title)
                assertEquals(
                    """
                        카카오톡에서 비즈니스는 어떻게 하는 걸까요? 
                        톡처럼 쉽게 비즈니스를 할 수 있는 방법은 없을까요?

                        카카오가 여러분의 비즈니스를 쉽게 성장시킬 수 있도록 변화합니다.
                        카카오 비즈니스의 개념과, 변화하는 플랫폼의 모습, 그리고 그 활용법에 대해 알아보겠습니다.
                    """.trimIndent(),
                    it.content
                )
                assertEquals("#카카오비즈니스 #카카오톡채널 #카카오광고 #카카오비즈도구 ", it.contentTag)
                assertEquals(
                    "https://tv.kakao.com/embed/player/cliplink/414132708",
                    it.linkList?.video?.get(0)?.url
                )
            }

            this[4].let {
                assertEquals("혁신의 씨앗을 뿌리다. <br>카카오임팩트 펠로우십", it.title)
                assertEquals(
                    """
                        혁신의 씨앗을 뿌리는 카카오임팩트의 새로운 시작!
                        2021년 1월, 우리 사회의 긍정적 변화를 만드는 사회혁신가들을 지원하는 '카카오임팩트펠로우십' 사업이 시작됩니다.

                        더 나은 사회를 만드는 사람들, 가치있는 혁신을 고민하는 사람들의 발걸음이 꾸준히 나아가고, 그들의 목소리가 퍼질 수 있게 오늘보다 더 나은 미래를 만드는 사람들을 찾아내고 지원합니다. '카카오임팩트펠로우십'은 혁신가들에게 가장 필요한 부분을 지혜롭게 챙겨주고, 그들의 메시지를 확산해주고 연결하는 역할을 하고자 합니다.
                    """.trimIndent(),
                    it.content
                )
                assertEquals("#사회혁신 #펠로우십 #카카오임팩트 #사회공헌", it.contentTag)
                assertEquals(
                    "https://tv.kakao.com/embed/player/cliplink/413991179",
                    it.linkList?.video?.get(0)?.url
                )
            }
        }
    }
}