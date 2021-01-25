package com.survivalcoding.ifkakao.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.model.Session
import com.survivalcoding.ifkakao.repository.ConferenceRepository

class ConferenceViewModel : ViewModel() {

    private val repository = ConferenceRepository()

    private val _sessions = MutableLiveData<List<Session>>()
    val sessions: LiveData<List<Session>>
        get() = _sessions

    fun requestConfData() {
        repository.requestConfData(::updateSessions)
    }

    private fun updateSessions(sessionList: List<Session>) {
        _sessions.postValue(sessionList)
    }
}