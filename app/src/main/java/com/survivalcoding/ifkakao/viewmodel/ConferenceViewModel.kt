package com.survivalcoding.ifkakao.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.model.Session
import com.survivalcoding.ifkakao.repository.ConferenceRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class ConferenceViewModel : ViewModel() {

    private val repository = ConferenceRepository()

    private val _sessions = MutableLiveData<List<Session>>()
    val sessions: LiveData<List<Session>>
        get() = _sessions

    val handler = CoroutineExceptionHandler { _, throwable ->
        Log.d("Retrofit Network Error", throwable.toString())
    }

    fun requestConfData() {
        viewModelScope.launch(handler) {
            _sessions.postValue(repository.requestConfData().data)
        }
    }
}