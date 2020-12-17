package com.survivalcoding.ifkakao.view.main

import androidx.lifecycle.ViewModel
import com.survivalcoding.ifkakao.data.ContentsRepository
import com.survivalcoding.ifkakao.model.Data

class MainViewModel : ViewModel() {
    private val contentsRepository = ContentsRepository()

    fun getContents(): List<Data> = contentsRepository.contents?.data ?: emptyList()
}