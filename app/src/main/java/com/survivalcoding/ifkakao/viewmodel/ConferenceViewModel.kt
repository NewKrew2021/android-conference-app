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
    val selectItem: MutableLiveData<Data> get() = _selectItem

    fun loadData() {
        repository.getRequests { _list.postValue(it) }
    }

    fun setSelectItem(data: Data) {
        _selectItem.value = data
    }


}