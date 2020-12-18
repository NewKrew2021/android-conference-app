package com.survivalcoding.ifkakao.data

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class ContentsRepositoryTest {
    private val contentsRepository = ContentsRepository()

    @Test
    fun getContents() {
        contentsRepository.getContents {
            assertNotNull(it)
            assertEquals(it!!.success, true)
            assertEquals(it!!.code, 0)
        }
    }
}