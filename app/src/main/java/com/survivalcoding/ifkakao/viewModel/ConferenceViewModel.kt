package com.survivalcoding.ifkakao.viewModel

import android.telecom.Conference
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.model.ConferenceAppFront
import com.survivalcoding.ifkakao.repository.ConferenceRepository

class ConferenceViewModel : ViewModel() {

    val conferenceRepository = ConferenceRepository()
    private val _listData = MutableLiveData<List<ConferenceAppFront>>()

    val listData get() = _listData

    fun getData() {
        conferenceRepository.getData({
            _listData.postValue(it)
        })
    }

}