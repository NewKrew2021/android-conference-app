package com.survivalcoding.ifkakao.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.data.model.response.ConferenceSessionResponse

class SessionDetailViewModel() : ViewModel() {

    private val _sessionData = MutableLiveData<ConferenceSessionResponse>()
    val sessionData : LiveData<ConferenceSessionResponse>
        get() = _sessionData

    fun setConferenceSessionData(data : ConferenceSessionResponse?) {
        if (data != null) {
            _sessionData.value = data
        }
    }



}