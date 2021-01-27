package com.survivalcoding.ifkakao.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FilterViewModel : ViewModel() {


    val filterList = MutableLiveData<List<Boolean>>().apply {
        val list = ObservableArrayList<Boolean>()
        for (i in 0..33) {
            list.add(false)
        }
        value = list
    }


}