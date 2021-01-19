package com.survivalcoding.ifkakao.viewmodel

import com.survivalcoding.ifkakao.repository.ConferenceRepository

class ConferenceViewModel(private val repository: ConferenceRepository) {
    fun getConferences(data: String) = repository.getConferencesFrom(data)
}