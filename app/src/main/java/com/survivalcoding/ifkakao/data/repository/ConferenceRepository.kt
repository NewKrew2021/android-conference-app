package com.survivalcoding.ifkakao.data.repository

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.survivalcoding.ifkakao.data.model.response.ConferenceResponse
import com.survivalcoding.ifkakao.data.model.response.ConferenceSessionResponse

class ConferenceRepository : ConferenceRepositoryContract {

    override fun getConferenceResponse() : List<ConferenceSessionResponse> {
        val moshi = Moshi.Builder().build()
        val adapter: JsonAdapter<ConferenceResponse> = moshi.adapter(ConferenceResponse::class.java)
        val result = adapter.fromJson(dummyData)
        return result?.data ?: listOf()
    }
}