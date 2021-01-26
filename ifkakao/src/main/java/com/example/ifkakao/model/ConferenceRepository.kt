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
        return if (result.isSuccessful) {
            result.body()?.let { KakaoApiResponse.Success(it) }
                ?: KakaoApiResponse.Failure(result.code()
                )
        } else {
            KakaoApiResponse.Failure(result.code())
        }
    }
}