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

    fun updateSessionData() {
        val conferenceData = repository.getConferenceData()
        _sessionList.value = conferenceData.data
    }
}