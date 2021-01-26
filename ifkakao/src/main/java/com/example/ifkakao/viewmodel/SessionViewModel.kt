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

enum class ErrorStatus() {
    SERVER_ERROR, CLIENT_ERROR, UNKNOWN_ERROR, NO_ERROR
}

class SessionViewModel : ViewModel() {
    private val repository: Repository = ConferenceRepository()
    private val _sessionList = MutableLiveData<List<Session>>(mutableListOf())
    val sessionList: LiveData<List<Session>> get() = _sessionList
    private val _highlightSession = MutableLiveData<List<Session>>(mutableListOf())
    val highlightSession: LiveData<List<Session>> get() = _highlightSession
    private val _selectedSession = MutableLiveData<Session>()
    val selectedSession: LiveData<Session> get() = _selectedSession
    var isLoading = MutableLiveData(false)
    var errorStatus = MutableLiveData(ErrorStatus.NO_ERROR)

    fun updateSessionData() {
        viewModelScope.launch {
            isLoading.value = true
            errorStatus.value = ErrorStatus.NO_ERROR
            when (val response = repository.getConferenceData()) {
                is KakaoApiResponse.Success -> {
                    _sessionList.value = response.result.data
                }
                is KakaoApiResponse.Failure -> {
                    when {
                        response.errorCode in 400..499 -> {
                            errorStatus.value = ErrorStatus.CLIENT_ERROR
                        }
                        response.errorCode >= 500 -> {
                            errorStatus.value = ErrorStatus.SERVER_ERROR
                        }
                        else -> {
                            errorStatus.value = ErrorStatus.UNKNOWN_ERROR
                        }
                    }
                }
            }
            isLoading.value = false
        }
    }

    fun updateHighlightSessionList() {
        viewModelScope.launch {
            isLoading.value = true
            errorStatus.value = ErrorStatus.NO_ERROR
            when (val response = repository.getConferenceData()) {
                is KakaoApiResponse.Success -> {
                    _highlightSession.value = response.result.data.filter { it.spotlightYn == "Y" }
                }
                is KakaoApiResponse.Failure -> {
                    when {
                        response.errorCode in 400..499 -> {
                            errorStatus.value = ErrorStatus.CLIENT_ERROR
                        }
                        response.errorCode >= 500 -> {
                            errorStatus.value = ErrorStatus.SERVER_ERROR
                        }
                        else -> {
                            errorStatus.value = ErrorStatus.UNKNOWN_ERROR
                        }
                    }
                }
            }
            isLoading.value = false
        }
    }

    fun setSelectedSession(item: Session) {
        _selectedSession.value = item
    }
}