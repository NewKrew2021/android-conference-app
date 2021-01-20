package com.survivalcoding.ifkakao

import com.survivalcoding.ifkakao.ifkakao.data.DataModel
import org.junit.Test
import org.junit.Assert.*

class ParseTest {

    @Test
    fun getParsedData() {
        val model = DataModel()
        val obj = model.getIfKakaoItem(model.getRequest())

        assertEquals(28, obj.data[0].idx)
        assertEquals("오프닝 키노트", obj.data[0].title)
        assertEquals(true, obj.success)
    }
}