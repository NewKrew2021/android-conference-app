package com.survivalcoding.ifkakao.data.remote.datasource

import com.survivalcoding.ifkakao.data.model.response.ConferenceSessionResponse
import com.survivalcoding.ifkakao.data.remote.api.IfKakaoApi
import retrofit2.Call

class RemoteDataSource(private val ifKakaoApi: IfKakaoApi) : IfKakaoApi {

    override fun getAllSession(): Call<List<ConferenceSessionResponse>> {
        return ifKakaoApi.getAllSession()
    }
}