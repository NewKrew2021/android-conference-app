package com.jayden.ifkakaoclone.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jayden.ifkakaoclone.data.repository.Repository
import com.jayden.ifkakaoclone.util.SingleLiveData
import com.jayden.ifkakaoclone.view.main.model.Session

class SessionViewModel(private val repository: Repository) : ViewModel() {
    data class Action(val type: Type, val url: String) {
        enum class Type {
            VIDEO_PLAY
        }
    }

    private val _sessions: MutableLiveData<List<Session>> by lazy {
        MutableLiveData<List<Session>>().also {
            fetchContents()
        }
    }
    val sessions: LiveData<List<Session>> get() = _sessions

    private val _selectedItem = MutableLiveData<Session>()
    val selectedItem: LiveData<Session> get() = _selectedItem

    private val _action = SingleLiveData<Action>()
    val action: LiveData<Action> get() = _action

    private val _isLoading = MutableLiveData<Boolean>(true)
    val isLoading: LiveData<Boolean> get() = _isLoading

    private fun fetchContents() {
        _isLoading.value = true
        repository.fetchContents {
            _isLoading.value = false

            _sessions.value = it
        }
    }

    fun setSelectedItem(session: Session) {
        _selectedItem.value = session
    }

    fun playVideo(url: String) {
        _action.value = Action(Action.Type.VIDEO_PLAY, url)
    }
}
