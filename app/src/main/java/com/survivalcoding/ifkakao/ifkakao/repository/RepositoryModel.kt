package com.survivalcoding.ifkakao.ifkakao.repository

import com.survivalcoding.ifkakao.ifkakao.model.IfKakaoResponse

class RepositoryModel : DefaultRepositoryModel {
    private val retrofitService = RetrofitFactory.service

    override suspend fun getParsedIfKakaoResponse(): IfKakaoResponse =
        retrofitService.getContentsData()
}