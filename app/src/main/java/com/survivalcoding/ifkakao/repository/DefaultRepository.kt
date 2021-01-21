package com.survivalcoding.ifkakao.repository

import com.survivalcoding.ifkakao.model.Session

interface DefaultRepository {
    fun getSessionsFrom(data: String): List<Session>
}