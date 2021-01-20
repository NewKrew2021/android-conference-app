package com.example.ifkakao.model

import com.example.ifkakao.model.jsonformat.ConferenceData
import com.squareup.moshi.Moshi

class ConferenceRepository : Repository {
    override fun getConferenceData(): ConferenceData {
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(ConferenceData::class.java)
        return adapter.fromJson(dummyData) ?: ConferenceData(false, 0, listOf(), null)
    }
}