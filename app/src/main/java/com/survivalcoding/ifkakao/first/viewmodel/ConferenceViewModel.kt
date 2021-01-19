package com.survivalcoding.ifkakao.first.viewmodel

import com.survivalcoding.ifkakao.first.model.repository.Repository

class ConferenceViewModel(private val repository: Repository) {
    fun getData() = repository.getData()
}