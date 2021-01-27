package com.survivalcoding.ifkakao.second.model.content.repository

import org.junit.After
import org.junit.Assert
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
        val data = repository.getDataWithDummy()

        Assert.assertEquals(5, data.data.size)
        Assert.assertEquals(0, data.code)
        Assert.assertNull(data.errorMessage)
        Assert.assertEquals(true, data.success)

        data.data[0].let { it ->
            Assert.assertEquals(28, it.idx)
            Assert.assertEquals("오프닝 키노트", it.title)
            it.linkList.let {
                Assert.assertEquals(0, it.file.size)
                Assert.assertEquals(1, it.video.size)
                Assert.assertEquals(4625, it.video[0].idx)
                Assert.assertEquals("N", it.video[0].mainYn)
            }
        }
    }
}