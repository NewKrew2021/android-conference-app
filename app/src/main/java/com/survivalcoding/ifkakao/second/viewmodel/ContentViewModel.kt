package com.survivalcoding.ifkakao.second.viewmodel

import com.survivalcoding.ifkakao.second.model.repository.Repository

class ContentViewModel(private val repository: Repository) {
    fun getData() = repository.getData()
}