package com.survivalcoding.ifkakao.second.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.second.model.ContentData
import com.survivalcoding.ifkakao.second.model.Speaker
import com.survivalcoding.ifkakao.second.model.repository.Repository
import kotlinx.coroutines.launch

class ContentViewModel(private val repository: Repository) : ViewModel() {
    private val _data = MutableLiveData<List<ContentData>>()
    val data: LiveData<List<ContentData>> get() = _data

    private val _speakers = MutableLiveData<List<Speaker>>()
    val speakers: LiveData<List<Speaker>> get() = _speakers

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private lateinit var _selectedItem: ContentData
    val selectedItem: ContentData get() = _selectedItem

    fun loadData() {
        viewModelScope.launch {
            _isLoading.value = true
            _data.value = repository.getData().data
            _isLoading.value = false
        }
    }

    fun setSelectedItem(item: ContentData) {
        _selectedItem = item
        _speakers.value = item.contentsSpeackerList
    }
}