package com.survivalcoding.ifkakao.ifkakao.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.ifkakao.ifkakao.model.Data
import com.survivalcoding.ifkakao.ifkakao.repository.RepositoryModel
import com.survivalcoding.ifkakao.ifkakao.repository.DefaultRepositoryModel
import com.survivalcoding.ifkakao.ifkakao.model.IfKakaoResponse
import com.survivalcoding.ifkakao.ifkakao.model.speakermodel.PresenterInfo
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