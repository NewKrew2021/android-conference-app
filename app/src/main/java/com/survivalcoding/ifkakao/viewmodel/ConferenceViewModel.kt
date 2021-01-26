package com.survivalcoding.ifkakao.viewmodel

import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
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

    var progressBarVisibility = ObservableField(View.GONE)

    private val handler = CoroutineExceptionHandler { _, throwable ->
        Log.e("Retrofit Network Error", throwable.toString())
    }

    fun requestConfData() {

        if (sessions.value.isNullOrEmpty()) {
            viewModelScope.launch(handler) {
                progressBarVisibility.set(View.VISIBLE)
                _sessions.postValue(repository.requestConfData().data)
                progressBarVisibility.set(View.GONE)
            }
        }
    }
}