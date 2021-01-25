package com.survivalcoding.ifkakao.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.model.conferenceData.Data
import com.survivalcoding.ifkakao.repository.ConferenceRepository

class ConferenceViewModel : ViewModel() {
    private val repository = ConferenceRepository

    private val _list = MutableLiveData<List<Data>>()
    val list: LiveData<List<Data>> get() = _list

    private val _selectItem = MutableLiveData<Data>()
    val selectItem: LiveData<Data> get() = _selectItem

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun loadData() {
        _isLoading.value = true
        repository.getRequests {
            _list.postValue(it)
            _isLoading.value = false
        }
    }

    fun setSelectItem(data: Data) {
        _selectItem.value = data
    }


}