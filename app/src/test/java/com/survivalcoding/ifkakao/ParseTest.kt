package com.survivalcoding.ifkakao

import com.survivalcoding.ifkakao.ifkakao.repository.RepositoryModel
import org.junit.Test
import org.junit.Assert.*

class ParseTest {

    @Test
    fun getParsedData() {
        val model = RepositoryModel()
        val obj = model.getIfKakaoItem(model.getRequest())

        assertEquals(28, obj.data[0].idx)
        assertEquals("오프닝 키노트", obj.data[0].title)
        assertEquals(true, obj.success)
    }
}