package com.survivalcoding.ifkakao.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.model.Session
import com.survivalcoding.ifkakao.model.like.Like
import com.survivalcoding.ifkakao.repository.LikeRepository
import com.survivalcoding.ifkakao.util.Event
import com.survivalcoding.ifkakao.util.SingleLiveEvent
import kotlinx.coroutines.launch

class DetailViewModel(
    private val likeRepository: LikeRepository,
    private val idx: Int,
) : ViewModel() {

    private val _likeState: LiveData<Boolean> = likeRepository.likeByIdx(idx)
    val likeState: LiveData<Boolean>
        get() = _likeState

    private val _targetUrl = SingleLiveEvent<String>()
    val targetUrl: LiveData<String>
        get() = _targetUrl

    private val _onBackButtonClicked = MutableLiveData<Event<Unit>>()
    val onBackButtonClicked: LiveData<Event<Unit>>
        get() = _onBackButtonClicked

    private val _onCopyButtonClicked = SingleLiveEvent<Unit>()
    val onCopyButtonClicked: LiveData<Unit>
        get() = _onCopyButtonClicked

    fun openVideoLink(target: Session) {
        _targetUrl.postValue(target.linkList.video[0].url)
    }

    fun popThisFragment() {
        _onBackButtonClicked.postValue(Event(Unit))
    }

    fun toggleLikeState() = viewModelScope.launch {

        if (_likeState.value == null) {
            likeRepository.updateState(Like(idx, true))
        } else {
            _likeState.value?.let {
                likeRepository.updateState(Like(idx, it xor true))
            }
        }
    }

    fun copyUrlLink() {
        _onCopyButtonClicked.postValue(Unit)
    }

}