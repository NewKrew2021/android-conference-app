package com.jayden.ifkakaoclone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jayden.ifkakaoclone.data.Repository
import com.jayden.ifkakaoclone.data.db.Favorite
import com.jayden.ifkakaoclone.util.SingleLiveData
import com.jayden.ifkakaoclone.view.main.model.Session
import kotlinx.coroutines.launch

class SessionViewModel(private val repository: Repository) : ViewModel() {
    data class Action(val type: Type, val url: String) {
        enum class Type {
            VIDEO_PLAY
        }
    }

    private val _sessions: MutableLiveData<List<Session>> by lazy { MutableLiveData<List<Session>>() }
    val sessions: LiveData<List<Session>> get() = _sessions

    private val _selectedItem = MutableLiveData<Session>()
    val selectedItem: LiveData<Session> get() = _selectedItem

    private val _action = SingleLiveData<Action>()
    val action: LiveData<Action> get() = _action

    private val _isLoading = MutableLiveData<Boolean>(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    val favorite: LiveData<List<Favorite>> = repository.getFavorites()

    private val _selectedFavorite = MutableLiveData<Favorite>()
    val selectedFavorite: LiveData<Favorite> get() = _selectedFavorite

    fun fetchContents() {
        viewModelScope.launch {
            _isLoading.value = true
            _sessions.value = repository.fetchContents()
            _isLoading.value = false
        }
    }

    fun setSelectedItem(session: Session) {
        _selectedItem.value = session
    }

    fun setSelectedFavorite(items: List<Favorite>) {
        val sessionIdx: Int? = selectedItem.value?.idx
        _selectedFavorite.value =
            items.find { sessionIdx == it.uid } ?: Favorite(uid = sessionIdx ?: 0)
    }

    fun playVideo(url: String) {
        _action.value = Action(Action.Type.VIDEO_PLAY, url)
    }

    fun updateFavorite() {
        _selectedFavorite.value?.let {
            it.isFavorite = !it.isFavorite
            repository.insertFavorite(it)
        }
    }
}
