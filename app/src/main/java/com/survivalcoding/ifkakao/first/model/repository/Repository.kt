package com.survivalcoding.ifkakao.first.model.repository

import com.survivalcoding.ifkakao.first.model.Conference

interface Repository {
    fun getData(): List<Conference>
}