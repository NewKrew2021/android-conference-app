package com.survivalcoding.ifkakao.data.remote.datasource

import com.survivalcoding.ifkakao.data.model.response.ConferenceResponse
import com.survivalcoding.ifkakao.data.remote.api.IfKakaoApi
import retrofit2.Response

class RemoteDataSource(private val ifKakaoApi: IfKakaoApi) : RemoteDataSourceContract {

    override suspend fun getAllSession(): Response<ConferenceResponse> {
        return ifKakaoApi.getAllSession()
    }
}

