package com.survivalcoding.ifkakao.second.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.second.model.ContentData
import com.survivalcoding.ifkakao.second.model.repository.ContentRepository

class ContentViewModel : ViewModel() {
    private val _data = MutableLiveData<List<ContentData>>()
    private val repository = ContentRepository()
    val data: LiveData<List<ContentData>>
        get() {
            return _data
        }

    fun loadData() {
        repository.getData {
            _data.value = it.data
        }
    }
}