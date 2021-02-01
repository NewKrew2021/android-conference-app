package com.survivalcoding.ifkakao.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.survivalcoding.ifkakao.repository.ConferenceRepository
import com.survivalcoding.ifkakao.repository.LikeRepository

class ConferenceViewModelFactory(
    private val confRepository: ConferenceRepository,
    private val likeRepository: LikeRepository,
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (ViewModel::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(
                ConferenceRepository::class.java,
                LikeRepository::class.java
            )
                .newInstance(confRepository, likeRepository)
        }
        return super.create(modelClass)
    }
}