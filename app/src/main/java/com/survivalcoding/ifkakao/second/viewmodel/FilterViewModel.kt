package com.survivalcoding.ifkakao.second.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.second.model.filter.Filter
import com.survivalcoding.ifkakao.second.model.filter.FilterType
import com.survivalcoding.ifkakao.second.util.find

class FilterViewModel : ViewModel() {


    private val _filters = MutableLiveData<Filter>(Filter(mapOf()))
    val filters: LiveData<Filter> get() = _filters


    fun addFilter(filterType: FilterType, name: String) {
        _filters.value?.let {
            _filters.value = Filter(it.data.toMutableMap().apply {
                put(filterType, name)
            })
        }
    }

    fun removeFilter(filterType: FilterType) {
        _filters.value?.let {
            _filters.value = Filter(it.data.toMutableMap().apply {
                remove(filterType)
            })
        }
    }


    fun resetFilter() {
        _filters.value = Filter(mapOf())
    }

    fun isSelectedFilter(filterType: FilterType, name: String): Boolean =
        _filters.value?.data?.find(filterType, name) ?: false


//    fun submitFilter() {
//        _filteredData.value = _data.value?.filter {
//            it.createdDateTime[9] == (_selectedDate).toString()[0] &&
//                    ((_filters.value?.containsValue(it.field)
//                        ?: true) || _filters.value?.isEmpty() ?: true)
//        }
//    }
}