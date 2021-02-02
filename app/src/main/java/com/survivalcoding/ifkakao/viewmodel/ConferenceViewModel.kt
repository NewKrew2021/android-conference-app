package com.survivalcoding.ifkakao.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.model.conferenceData.Data
import com.survivalcoding.ifkakao.repository.ConferenceRepository
import kotlinx.coroutines.launch

class ConferenceViewModel : ViewModel() {

    private val repository = ConferenceRepository
    private val _list = MutableLiveData<List<Data>>()
    val list: LiveData<List<Data>> get() = _list

    private val _selectItem = MutableLiveData<Data>()
    val selectItem: LiveData<Data> get() = _selectItem

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _isShareWindow = MutableLiveData(false)
    val isShareWindow: LiveData<Boolean> get() = _isShareWindow


    fun loadData() {
        viewModelScope.launch {
            _isLoading.value = true

            _list.postValue(repository.getRequests().data)

            _isLoading.value = false
        }

    }

    fun setSelectItem(data: Data) {
        _selectItem.value = data
    }

    fun onShareWindow() {
        _isShareWindow.value = true
    }

    fun offShareWindow() {
        _isShareWindow.value = false
    }

    fun setFilterList(filterList: List<Data>) {
        _list.postValue(filterList)
    }
}