package com.survivalcoding.ifkakao.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FilterViewModel : ViewModel() {

    val list = ObservableArrayList<Boolean>()
    val filterList = MutableLiveData<ObservableArrayList<Boolean>>().apply {
        for (i in 0..33) {
            list.add(false)
        }
        value = list
    }


}