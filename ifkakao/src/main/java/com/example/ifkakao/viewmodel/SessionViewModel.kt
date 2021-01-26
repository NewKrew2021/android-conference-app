package com.example.ifkakao.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ifkakao.model.ConferenceRepository
import com.example.ifkakao.model.KakaoApiResponse
import com.example.ifkakao.model.Repository
import com.example.ifkakao.model.jsonformat.Session
import kotlinx.coroutines.launch

class SessionViewModel : ViewModel() {
    private val repository: Repository = ConferenceRepository()
    private val _sessionList = MutableLiveData<List<Session>>(mutableListOf())
    val sessionList: LiveData<List<Session>> get() = _sessionList
    private val _selectedSession = MutableLiveData<Session>()
    val selectedSession: LiveData<Session> get() = _selectedSession
    var isLoading = MutableLiveData(false)

    fun updateSessionData() {
        viewModelScope.launch {
            isLoading.value = true
            when (val response = repository.getConferenceData()) {
                is KakaoApiResponse.Success -> {
                    _sessionList.value = response.result.data
                }
                is KakaoApiResponse.Failure -> {

                }
            }
            isLoading.value = false
        }
    }

    fun setSelectedSession(item: Session) {
        _selectedSession.value = item
    }
}