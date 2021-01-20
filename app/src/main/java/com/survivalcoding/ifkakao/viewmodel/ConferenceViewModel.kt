package com.survivalcoding.ifkakao.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.model.Conference
import com.survivalcoding.ifkakao.repository.ConferenceRepository

class ConferenceViewModel : ViewModel() {

    private val repository = ConferenceRepository()

    private val _conferences = MutableLiveData<List<Conference>>()
    val conferences: LiveData<List<Conference>>
        get() = _conferences

    fun loadConferencesFrom(data: String) {
        _conferences.postValue(repository.getConferencesFrom(data))
    }
}