package com.survivalcoding.ifkakao.second.model.repository

import com.survivalcoding.ifkakao.second.model.Contents

interface Repository {
    suspend fun getData(): Contents
}