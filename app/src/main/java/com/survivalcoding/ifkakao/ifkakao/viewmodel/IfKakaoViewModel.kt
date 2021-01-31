package com.survivalcoding.ifkakao.ifkakao.viewmodel

import androidx.lifecycle.*
import com.survivalcoding.ifkakao.ifkakao.model.Data
import com.survivalcoding.ifkakao.ifkakao.repository.RepositoryModel
import com.survivalcoding.ifkakao.ifkakao.repository.DefaultRepositoryModel
import com.survivalcoding.ifkakao.ifkakao.model.IfKakaoResponse
import kotlinx.coroutines.launch

class IfKakaoViewModel : ViewModel() {
    private val _ifKakaoSessionList = MutableLiveData<IfKakaoResponse>()
    val ifKakaoSessionList: LiveData<IfKakaoResponse>  // liveData getter
        get() = _ifKakaoSessionList

    private val ifKakaoRepositoryModel: DefaultRepositoryModel = RepositoryModel()

    fun loadIfKakaoItem() {
        viewModelScope.launch {
            _ifKakaoSessionList.value = ifKakaoRepositoryModel.getParsedIfKakaoResponse()
        }
    }
}