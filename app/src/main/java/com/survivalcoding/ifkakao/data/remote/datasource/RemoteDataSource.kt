package com.survivalcoding.ifkakao.data.remote.datasource

import com.survivalcoding.ifkakao.data.model.response.ConferenceResponse
import com.survivalcoding.ifkakao.data.remote.api.IfKakaoApi

class RemoteDataSource(private val ifKakaoApi: IfKakaoApi) : RemoteDataSourceContract {

    override suspend fun getAllSession() : ConferenceResponse = ifKakaoApi.getAllSession()
}

