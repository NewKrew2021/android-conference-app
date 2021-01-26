package com.survivalcoding.ifkakao.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.data.model.response.ConferenceSessionResponse

class SessionDetailViewModel : ViewModel() {

    lateinit var sessionData : ConferenceSessionResponse

    fun setConferenceSessionData(data : ConferenceSessionResponse?) {
        if (data != null) {
            this.sessionData = data
        }
    }
}