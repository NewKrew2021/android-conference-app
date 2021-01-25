package com.survivalcoding.ifkakao.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.model.Session
import com.survivalcoding.ifkakao.util.SingleLiveEvent

class DetailViewModel : ViewModel() {

    private val _targetUrl = SingleLiveEvent<String>()
    val targetUrl: LiveData<String>
        get() = _targetUrl

    fun openVideoLink(target: Session) {
        _targetUrl.postValue(target.linkList.video[0].url)
    }

}