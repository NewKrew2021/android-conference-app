package com.survivalcoding.ifkakao.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.data.model.response.ConferenceSessionResponse
import com.survivalcoding.ifkakao.data.repository.ConferenceRepository
import com.survivalcoding.ifkakao.extension.toLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ConferenceRepository) : ViewModel() {

    private val _conferenceData = MutableLiveData<List<ConferenceSessionResponse>>()
    val conferenceData = _conferenceData.toLiveData()

    fun getConferenceData() {
        viewModelScope.launch {
            _conferenceData.postValue(repository.getAllSession().data)
        }
        GlobalScope.launch {

        }
    }

}