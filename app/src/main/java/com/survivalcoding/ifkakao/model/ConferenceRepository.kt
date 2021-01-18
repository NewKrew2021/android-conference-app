package com.survivalcoding.ifkakao.model

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

// TODO: Retrofit2 / OkHttp3 적용해서 더미 데이터 대체
class ConferenceRepository : Repository {
    override fun getConferenceData(): List<ConferenceInfo> {

        val moshi = Moshi.Builder().build()
        val listType = Types.newParameterizedType(List::class.java, ConferenceInfo::class.java)
        val adapter = moshi.adapter<List<ConferenceInfo>>(listType)
        return adapter.fromJson(dummyData) ?: listOf()
    }
}