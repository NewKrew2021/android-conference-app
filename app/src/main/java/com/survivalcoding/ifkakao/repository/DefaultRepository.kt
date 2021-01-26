package com.survivalcoding.ifkakao.repository

import com.survivalcoding.ifkakao.model.Session

interface DefaultRepository {
    fun requestConfData(callback: (List<Session>) -> Unit)
}