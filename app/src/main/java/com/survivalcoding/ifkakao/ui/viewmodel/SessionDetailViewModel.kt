package com.survivalcoding.ifkakao.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.data.model.entity.Favorite
import com.survivalcoding.ifkakao.data.model.response.ConferenceSessionResponse
import com.survivalcoding.ifkakao.data.repository.ConferenceRepository
import kotlinx.coroutines.launch

class SessionDetailViewModel(private val repository: ConferenceRepository) : ViewModel() {

    private val _sessionData = MutableLiveData<ConferenceSessionResponse>()
    val sessionData : LiveData<ConferenceSessionResponse>
        get() = _sessionData

    private val _favoriteCheck = MutableLiveData<Boolean>()
    val favoriteCheck : LiveData<Boolean>
        get() = _favoriteCheck

    fun setConferenceSessionData(data : ConferenceSessionResponse?) {
        if (data != null) {
            _sessionData.value = data
        }
    }

    fun getFavoriteSessionData() {
        viewModelScope.launch {
            _favoriteCheck.value = repository.getAllFavoriteSessionId().contains(_sessionData.value?.idx)
        }
    }

    fun deleteFavoriteSession(id: Int) {
        viewModelScope.launch {
            repository.deleteFavoriteSessionById(id)
        }
        _favoriteCheck.value = false
    }

    fun insertFavoriteSession(favorite: Favorite) {
        viewModelScope.launch {
            repository.insertFavoriteSession(favorite)
        }
        _favoriteCheck.value = true
    }



}