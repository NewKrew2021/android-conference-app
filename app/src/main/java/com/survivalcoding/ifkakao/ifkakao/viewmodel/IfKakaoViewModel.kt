package com.survivalcoding.ifkakao.ifkakao.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.survivalcoding.ifkakao.ifkakao.database.FavoriteTable
import com.survivalcoding.ifkakao.ifkakao.model.Data
import com.survivalcoding.ifkakao.ifkakao.repository.RepositoryModel
import com.survivalcoding.ifkakao.ifkakao.repository.DefaultRepositoryModel
import com.survivalcoding.ifkakao.ifkakao.model.IfKakaoResponse
import com.survivalcoding.ifkakao.ifkakao.repository.FavoriteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class IfKakaoViewModel : ViewModel() {
    private val _ifKakaoSessionList = MutableLiveData<IfKakaoResponse>()
    val ifKakaoSessionList: LiveData<IfKakaoResponse>  // liveData getter
        get() = _ifKakaoSessionList

    private val _presentationData = MutableLiveData<Data>()
    val presentationData: LiveData<Data>
        get() = _presentationData

    private val ifKakaoRepositoryModel: DefaultRepositoryModel = RepositoryModel()

    fun loadIfKakaoItem() {
        viewModelScope.launch {
            _ifKakaoSessionList.value = ifKakaoRepositoryModel.getParsedIfKakaoResponse()
        }
    }

    fun setPresentationData(item: Data) {
        _presentationData.value = item
    }
}