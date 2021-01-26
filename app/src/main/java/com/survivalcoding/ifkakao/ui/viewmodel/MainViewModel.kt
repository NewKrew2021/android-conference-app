package com.survivalcoding.ifkakao.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.data.model.response.ConferenceSessionResponse
import com.survivalcoding.ifkakao.data.repository.ConferenceRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ConferenceRepository) : ViewModel() {

    private val _conferenceData = MutableLiveData<List<ConferenceSessionResponse>>()
    val conferenceData: LiveData<List<ConferenceSessionResponse>>
        get() = _conferenceData

    fun getConferenceData() {
        viewModelScope.launch {
            _conferenceData.postValue(repository.getAllSession().data)
        }

    }

}