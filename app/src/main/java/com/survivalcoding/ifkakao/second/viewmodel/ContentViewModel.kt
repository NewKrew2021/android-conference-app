package com.survivalcoding.ifkakao.second.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.second.model.content.ContentData
import com.survivalcoding.ifkakao.second.model.content.Repository
import kotlinx.coroutines.launch

class ContentViewModel(
    private val repository: Repository,
) : ViewModel() {
    private var _data: List<ContentData> = listOf()

    private val _filteredData = MutableLiveData<List<ContentData>>()
    val filteredData: LiveData<List<ContentData>> get() = _filteredData

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private var _selectedDate = -1
    val selectedDate get() = _selectedDate


    fun loadData() {
        if (_data.isEmpty()) {
            viewModelScope.launch {
                _isLoading.value = true
                _data = repository.getData().data
                _filteredData.value = _data
                _isLoading.value = false
            }
        }
    }

    fun setSelectedDate(date: Int) {
        _selectedDate = date
        submitFilter()
    }

    fun submitFilter() {
        _filteredData.value = _data.filter {
            it.createdDateTime[9] == (_selectedDate).toString()[0]
        }
    }
}