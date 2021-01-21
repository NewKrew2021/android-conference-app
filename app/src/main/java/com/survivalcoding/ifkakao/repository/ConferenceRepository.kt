package com.survivalcoding.ifkakao.repository

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.survivalcoding.ifkakao.model.Response
import com.survivalcoding.ifkakao.model.Session

class ConferenceRepository : DefaultRepository {

    override fun getSessionsFrom(data: String): List<Session> {
        val moshi = Moshi.Builder().build()
        val listTypes = Types.getRawType(Response::class.java)
        val adapter = moshi.adapter<Response>(listTypes)
        return adapter.fromJson(data)?.data ?: listOf()
    }
}