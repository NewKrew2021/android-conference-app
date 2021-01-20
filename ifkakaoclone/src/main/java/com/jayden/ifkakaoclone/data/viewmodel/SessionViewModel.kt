package com.jayden.ifkakaoclone.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jayden.ifkakaoclone.data.repository.Repository
import com.jayden.ifkakaoclone.view.main.model.Session

class SessionViewModel(private val repository: Repository) : ViewModel() {
    private val _sessions: MutableLiveData<List<Session>> by lazy {
        MutableLiveData<List<Session>>().also {
            it.value = loadSessions()
        }
    }
    val sessions: LiveData<List<Session>>
        get() = _sessions

    private fun loadSessions(): List<Session> = repository.getSessions()
}