package com.survivalcoding.ifkakao.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.model.conferenceData.Data
import com.survivalcoding.ifkakao.repository.ConferenceRepository

class ConferenceViewModel : ViewModel() {
    private val repository = ConferenceRepository()
    private val _list = MutableLiveData<List<Data>>()
    val list: LiveData<List<Data>> get() = _list
    fun loadData() {
        repository.getRequests {
            _list.postValue(it)
        }
    }
    fun a(){
    }
}