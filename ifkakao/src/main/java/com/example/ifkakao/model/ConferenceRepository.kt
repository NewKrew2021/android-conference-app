package com.example.ifkakao.model

import com.example.ifkakao.model.jsonformat.ConferenceData
import com.squareup.moshi.Moshi

// 더미데이터가 너무 커서 txt 파일로 저장했는데, Repository 에서 txt 파일을 사용하려면 context 가 필요함.
// 네트워크 연동하기 전까지 Repository 의 생성자로 더미데이터를 주입시켜줘야할 것 같음.
class ConferenceRepository(private val dummyData: String) : Repository {
    override fun getConferenceData(): ConferenceData {
        val moshi = Moshi.Builder().build()
        val adapter = moshi.adapter(ConferenceData::class.java)
        return adapter.fromJson(dummyData) ?: ConferenceData(false, 0, listOf(), null)
    }
}