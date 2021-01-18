package com.survivalcoding.ifkakao.viewmodel

import com.survivalcoding.ifkakao.model.ConferenceRepository

class ConferenceViewModel {
    private val repository = ConferenceRepository()

    fun getConferenceData() = repository.getConferenceData()
}