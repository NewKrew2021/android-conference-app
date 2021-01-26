package com.example.ifkakao.model

import com.example.ifkakao.model.jsonformat.ConferenceData

sealed class KakaoApiResponse {
    class Success(val result: ConferenceData) : KakaoApiResponse()
    class Failure(val errorCode: Int) : KakaoApiResponse()
}

class ConferenceRepository : Repository {
    private val remoteDataSource = RemoteDataSource()

    override suspend fun getConferenceData(): KakaoApiResponse {
        val result = remoteDataSource.getConferenceData()
        if (result.isSuccessful) {
            return result.body()?.let { KakaoApiResponse.Success(it) }
                ?: KakaoApiResponse.Failure(result.code()
                )
        } else {
            return KakaoApiResponse.Failure(result.code())
        }
    }
}