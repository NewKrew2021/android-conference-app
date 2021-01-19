package com.survivalcoding.ifkakao.repository

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.survivalcoding.ifkakao.model.Conference
import com.survivalcoding.ifkakao.model.Response

class ConferenceRepository : DefaultRepository {

    override fun getConferencesFrom(data: String): List<Conference> {
        val moshi = Moshi.Builder().build()
        val listTypes = Types.getRawType(Response::class.java)
        val adapter = moshi.adapter<Response>(listTypes)
        return adapter.fromJson(data)?.data ?: listOf()
    }
}