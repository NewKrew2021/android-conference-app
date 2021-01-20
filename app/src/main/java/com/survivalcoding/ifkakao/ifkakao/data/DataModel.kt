package com.survivalcoding.ifkakao.ifkakao.data

import com.squareup.moshi.Moshi
import com.survivalcoding.ifkakao.ifkakao.model.IfKakaoItem

class DataModel: DefaultDataModel {
    override fun getIfKakaoItem(json: String): IfKakaoItem {
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(IfKakaoItem::class.java)
        val data = adapter.fromJson(json)
        data?.let { return data }
        return IfKakaoItem(0, listOf(), "cannot parsing", false)
    }
}