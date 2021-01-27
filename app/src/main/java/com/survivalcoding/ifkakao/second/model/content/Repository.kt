package com.survivalcoding.ifkakao.second.model.content

interface Repository {
    suspend fun getData(): Contents
}