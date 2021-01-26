package com.survivalcoding.ifkakao.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.model.Session
import com.survivalcoding.ifkakao.util.Event
import com.survivalcoding.ifkakao.util.SingleLiveEvent

class DetailViewModel : ViewModel() {

    private val _targetUrl = SingleLiveEvent<String>()
    val targetUrl: LiveData<String>
        get() = _targetUrl

    private val _onBackButtonClicked = MutableLiveData<Event<Unit>>()
    val onBackButtonClicked: LiveData<Event<Unit>>
        get() = _onBackButtonClicked

    fun openVideoLink(target: Session) {
        _targetUrl.postValue(target.linkList.video[0].url)
    }

    fun popThisFragment() {
        _onBackButtonClicked.postValue(Event(Unit))
    }
}