package com.survivalcoding.ifkakao.second.model.repository

import com.survivalcoding.ifkakao.second.model.Contents

interface Repository {
    fun getData(callback: (Contents) -> Unit)
}