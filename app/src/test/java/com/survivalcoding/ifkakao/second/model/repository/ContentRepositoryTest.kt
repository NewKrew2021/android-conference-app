package com.survivalcoding.ifkakao.second.model.repository

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class ContentRepositoryTest {

    private val repository = ContentRepository()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getData() {
        val data = repository.getData()

        assertEquals(5, data.data.size)
        assertEquals(0, data.code)
        assertNull(data.errorMessage)
        assertEquals(true, data.success)

        data.data[0].let { it ->
            assertEquals(28, it.idx)
            assertEquals("오프닝 키노트", it.title)
            it.linkList.let {
                assertEquals(0, it.file.size)
                assertEquals(1, it.video.size)
                assertEquals(4625, it.video[0].idx)
                assertEquals("N", it.video[0].mainYn)
            }
        }
    }
}