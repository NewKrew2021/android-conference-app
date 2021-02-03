package com.jayden.ifkakaoclone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import java.util.*

class MyViewModel : ViewModel() {

    private val _liveData1 = MutableLiveData<String>()
    val liveData1: LiveData<String> get() = _liveData1

    // Transformations.map()
    // liveData1이 변경될 때마다 map()이 반환하는 새로운 LiveData 의 value 역시 새롭게 갱신된다.
    // -> 내부적으로 MediatorLiveData 를 사용하고 있기 때문이다.
    val liveData2: LiveData<String> = _liveData1.map { it.toUpperCase(Locale.getDefault()) }

    fun setNewValue(newValue: String) {
        _liveData1.value = newValue
    }
}