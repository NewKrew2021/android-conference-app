package com.survivalcoding.ifkakao.second.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.second.model.ContentData
import com.survivalcoding.ifkakao.second.model.repository.Repository

class ContentViewModel(private val repository: Repository) : ViewModel() {
    private val _data = MutableLiveData<List<ContentData>>()
    val data: LiveData<List<ContentData>> get() = _data

    private val _selectedItem = MutableLiveData<ContentData>()
    val selectedItem: LiveData<ContentData> get() = _selectedItem

    fun loadData() {
        repository.getData {
            _data.value = it.data
        }
    }

    fun setSelectedItem(item: ContentData) {
        _selectedItem.value = item
    }
}