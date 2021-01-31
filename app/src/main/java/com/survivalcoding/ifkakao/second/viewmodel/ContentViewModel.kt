package com.survivalcoding.ifkakao.second.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.second.model.content.ContentData
import com.survivalcoding.ifkakao.second.model.content.Repository
import com.survivalcoding.ifkakao.second.model.filter.FilterType
import com.survivalcoding.ifkakao.second.util.find
import kotlinx.coroutines.launch

class ContentViewModel(
    private val repository: Repository,
) : ViewModel() {
    private val _data = MutableLiveData<List<ContentData>>()
    val data: LiveData<List<ContentData>> get() = _data

    private val _filteredData = MutableLiveData<List<ContentData>>()
    val filteredData: LiveData<List<ContentData>> get() = _filteredData

    private val _isLoading = MutableLiveData(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private var _selectedDate: Int = -1


    private val _filters = MutableLiveData<Map<FilterType, String>>(mapOf())
    val filters: LiveData<Map<FilterType, String>> get() = _filters


    fun loadData() {
        viewModelScope.launch {
            _isLoading.value = true
            _data.value = repository.getData().data
            _isLoading.value = false
            _filteredData.value = _data.value
        }
    }

    fun addFilter(filterType: FilterType, name: String) {
        _filters.value?.let {
            _filters.value = it.toMutableMap().apply {
                put(filterType, name)
            }
        }
    }

    fun removeFilter(filterType: FilterType) {
        _filters.value?.let {
            _filters.value = it.toMutableMap().apply {
                remove(filterType)
            }
        }
    }


    fun resetFilter() {
        _filters.value = mapOf()
    }

    fun isSelectedFilter(filterType: FilterType, name: String): Boolean =
        _filters.value?.find(filterType, name) ?: false

    fun setSelectedDate(date: Int) {
        _selectedDate = date
        _filteredData.value =
            _data.value?.filter { _selectedDate == -1 || it.createdDateTime[9] == (date).toString()[0] }
    }

    fun submitFilter() {
        _filteredData.value = _data.value?.filter {
            it.createdDateTime[9] == (_selectedDate).toString()[0] &&
                    ((_filters.value?.containsValue(it.field)
                        ?: true) || _filters.value?.isEmpty() ?: true)
        }
    }
}