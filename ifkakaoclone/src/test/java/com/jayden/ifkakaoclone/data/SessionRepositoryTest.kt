package com.jayden.ifkakaoclone.data

import com.jayden.ifkakaoclone.data.network.RemoteDataSource
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

private const val SESSIONS_ITEM_SIZE = 54

class SessionRepositoryTest {
    private val remoteDataSource = RemoteDataSource()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun fetchContents() = runBlocking {
        val result = remoteDataSource.fetchContents()
        assertEquals(SESSIONS_ITEM_SIZE, result.size)

        with(result[0]) {
            assertEquals("오프닝 키노트", title)
            assertEquals(
                """
                    if(kakao)2020은 더 나은 세상을 만들기 위한 카카오의 많은 생각과 도전들을 담았습니다.
                    오프닝키노트를 시작으로 11월 18일부터 3일 동안 다양한 카카오의 이야기가 펼쳐집니다. 
                    if(kakao)에서 카카오의 변화를 함께 확인해 보시죠!

                    오늘도 카카오는 일상을 바꾸는 중.
                """.trimIndent(), content
            )
            assertEquals("https://tv.kakao.com/embed/player/cliplink/414004572", linkList.video[0].url)
        }

        with(result[10]) {
            assertEquals("Hello, Open API World!", title)
            assertEquals(
                """
                    카카오가 제공하는 다양한 Open API를 소개합니다. 카카오는 Open API를 통해 카카오의 소셜 그래프, 지도 데이터, 인공지능 플랫폼까지 폭넓은 기술과 데이터를 사용자들과 공유하고 있습니다. 카카오 API를 사용하여 어떤 기능들을 보다 쉽고 편리하게 구현할 수 있는지 알아보세요.
                """.trimIndent(), content
            )
            assertEquals("https://tv.kakao.com/embed/player/cliplink/413991719", linkList.video[0].url)
        }

        with(result[53]) {
            assertEquals("톡에서 발견하는 신규 고객, <br>카카오 X 정육각", title)
            assertEquals(
                """
                    초.신선 돼지고기를 판매하는 정육각과 카카오가 만나면?
                    카카오와 정육각이 만나게 된 과정, 그리고 톡 안에서 정육각의 신규 고객을 확보하게 된 이야기를 들어봅니다. 
                """.trimIndent(), content
            )
            assertEquals("https://tv.kakao.com/embed/player/cliplink/414072194", linkList.video[0].url)
        }
    }
}