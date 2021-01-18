package com.survivalcoding.ifkakao.data.repository

import com.survivalcoding.ifkakao.view.main.model.Conference

interface Repository {
    fun getItems(): List<Conference>
}