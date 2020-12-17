package com.survivalcoding.ifkakao.data

import org.junit.Test

import org.junit.Assert.*

class ContentsRepositoryTest {
    private val contentsRepository = ContentsRepository()

    @Test
    fun getContents() {
        assertNotNull(contentsRepository.contents)

        assertEquals(contentsRepository.contents!!.data[0].idx, 28)
        assertEquals(contentsRepository.contents!!.data[0].createdUserIdx, 10)
    }
}