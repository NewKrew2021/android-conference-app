package com.survivalcoding.ifkakao.repository

import com.survivalcoding.ifkakao.model.Conference

interface DefaultRepository {
    fun getConferencesFrom(data: String): List<Conference>
}