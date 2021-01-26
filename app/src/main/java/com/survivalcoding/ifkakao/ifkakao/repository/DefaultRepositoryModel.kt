package com.survivalcoding.ifkakao.ifkakao.repository

import com.survivalcoding.ifkakao.ifkakao.model.IfKakaoResponse

interface DefaultRepositoryModel {
    suspend fun getParsedIfKakaoResponse() : IfKakaoResponse
}