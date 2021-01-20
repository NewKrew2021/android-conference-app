package com.survivalcoding.ifkakao.ifkakao.data

import com.survivalcoding.ifkakao.ifkakao.model.IfKakaoItem

interface DefaultDataModel {
    fun getIfKakaoItem(json: String): IfKakaoItem

    fun getRequest(): String
}