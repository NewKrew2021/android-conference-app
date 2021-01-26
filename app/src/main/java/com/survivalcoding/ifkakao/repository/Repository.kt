package com.survivalcoding.ifkakao.repository

import com.survivalcoding.ifkakao.model.Requests


interface Repository {
    suspend fun getRequests() : Requests
}
