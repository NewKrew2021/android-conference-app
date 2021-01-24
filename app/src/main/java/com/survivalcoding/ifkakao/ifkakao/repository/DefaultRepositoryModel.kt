package com.survivalcoding.ifkakao.ifkakao.repository

import com.survivalcoding.ifkakao.ifkakao.model.IfKakaoResponse

interface DefaultRepositoryModel {
    fun getParsedIfKakaoResponse(json: String): IfKakaoResponse

    fun getRequest(): String
}