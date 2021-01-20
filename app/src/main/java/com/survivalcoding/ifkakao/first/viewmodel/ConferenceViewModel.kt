package com.survivalcoding.ifkakao.first.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.first.model.Conference
import com.survivalcoding.ifkakao.first.model.repository.ConferenceRepository

class ConferenceViewModel : ViewModel() {
    private val _data = MutableLiveData<List<Conference>>()
    private val repository = ConferenceRepository()
    val data: LiveData<List<Conference>>
        get() {
            return _data
        }

    fun loadData() {
        repository.getData {
            _data.value = it
        }
    }
}