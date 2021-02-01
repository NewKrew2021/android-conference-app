package com.survivalcoding.ifkakao.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FilterViewModel : ViewModel() {


    val filterList = MutableLiveData<ObservableArrayList<Boolean>>().apply {
        val list = ObservableArrayList<Boolean>()
        for (i in 0..33) {
            list.add(false)
        }
        value = list
    }


    private val _filterSize = MutableLiveData<Int>(0)

    val filterSize: LiveData<Int> get() = _filterSize

    private val _adaptFilter = MutableLiveData<MutableList<String>>().apply {
        value = mutableListOf<String>()
    }

    val adaptFilter: LiveData<MutableList<String>> get() = _adaptFilter


    fun setFilterSize(check: Boolean) {
        if (check) {
            _filterSize.value = _filterSize.value?.plus(1)
        } else {
            _filterSize.value = _filterSize.value?.minus(1)
        }

    }

    fun setInitFilter() {
        for (i in 0..33) {
            filterList.value?.set(i, false)
        }
        _filterSize.value = 0
    }

    fun setAdaptFilter() {
        _adaptFilter.value?.clear()
        for (i in 0..33) {
            if (filterList.value?.get(i) == true) {
                _adaptFilter.value?.add(filterStringList[i])
            }
        }

    }


    companion object {
        val filterStringList = listOf("서비스", "비즈니스", "기술", "개인화", "광고", "금융", "데이터", "디지털자산", "모빌리티", "사회공헌", "엔지니어링", "인프라", "콘텐츠", "크리에이터", "플랫폼",
                "B2B", "백엔드", "머신러닝/AI", "데이터", "클라우드", "인프라/DevOps", "블록체인", "모바일", "Android", "iOS", "웹/프론트엔드", "Windows", "게임개발", "개발생태계", "개발문화", "하드웨어", "EmbeddedSystem", "기타")
    }

}