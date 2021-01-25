package com.example.ifkakao.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ifkakao.model.ConferenceRepository
import com.example.ifkakao.model.Repository
import com.example.ifkakao.model.jsonformat.Session

class SessionViewModel : ViewModel() {
    private val repository: Repository = ConferenceRepository()
    private val _sessionList = MutableLiveData<List<Session>>(mutableListOf())
    val sessionList: LiveData<List<Session>> get() = _sessionList
    private val _selectedSession = MutableLiveData<Session>()
    val selectedSession: LiveData<Session> get() = _selectedSession

    fun updateSessionData() {
        repository.getConferenceData {
            _sessionList.value = it.data
        }
    }

    fun setSelectedSession(item: Session) {
        _selectedSession.value = item
    }
}