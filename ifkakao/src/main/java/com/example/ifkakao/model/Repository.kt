package com.example.ifkakao.model

interface Repository {
    suspend fun getConferenceData(): KakaoApiResponse
}