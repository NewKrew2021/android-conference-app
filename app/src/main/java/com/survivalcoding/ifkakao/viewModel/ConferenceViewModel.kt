package com.survivalcoding.ifkakao.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.model.ConferenceAppFront
import com.survivalcoding.ifkakao.repository.ConferenceRepository

class ConferenceViewModel : ViewModel() {

    private val _listData = MutableLiveData<List<ConferenceAppFront>>()
    val listData get() = _listData
    var currentPosition = 0
    private var _singleData = MutableLiveData<ConferenceAppFront>()
    val singleData get() = _singleData

    fun getData() {
        ConferenceRepository.getData({
            _listData.postValue(it)
        })
    }
}