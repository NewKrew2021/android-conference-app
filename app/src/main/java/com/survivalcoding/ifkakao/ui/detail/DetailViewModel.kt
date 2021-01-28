package com.survivalcoding.ifkakao.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.database.AppDatabase
import com.survivalcoding.ifkakao.model.Session
import com.survivalcoding.ifkakao.model.like.Like
import com.survivalcoding.ifkakao.repository.LikeRepository
import com.survivalcoding.ifkakao.util.Event
import com.survivalcoding.ifkakao.util.SingleLiveEvent
import kotlinx.coroutines.launch

class DetailViewModel(
    application: Application,
    private val idx: Int,
) :
    AndroidViewModel(application) {

    private val repository =
        LikeRepository(AppDatabase.getDatabase(application).likeDao())

    private val _likeState: LiveData<Boolean> = repository.likeByIdx(idx)
    val likeState: LiveData<Boolean>
        get() = _likeState

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

    fun toggleLikeState() = viewModelScope.launch {

        if (_likeState.value == null) {
            repository.updateState(Like(idx, true))
        } else {
            _likeState.value?.let {
                repository.updateState(Like(idx, it xor true))
            }
        }
    }

}