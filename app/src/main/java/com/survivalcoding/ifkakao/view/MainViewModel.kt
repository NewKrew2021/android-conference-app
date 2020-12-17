package com.survivalcoding.ifkakao.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.data.ContentsRepository
import com.survivalcoding.ifkakao.model.Data

class MainViewModel : ViewModel() {
    private val _selectedItem = MutableLiveData<Data>()
    val selectedItem: LiveData<Data> get() = _selectedItem

    private val contentsRepository = ContentsRepository()

    fun getContents(): List<Data> = contentsRepository.contents?.data ?: emptyList()

    fun selectItem(item: Data) {
        _selectedItem.value = item
    }
}