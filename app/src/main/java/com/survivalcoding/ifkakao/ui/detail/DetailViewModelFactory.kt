package com.survivalcoding.ifkakao.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.survivalcoding.ifkakao.repository.LikeRepository

class DetailViewModelFactory(
    private val likeRepository: LikeRepository,
    private val idx: Int,
) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (ViewModel::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(LikeRepository::class.java, Int::class.java)
                .newInstance(likeRepository, idx)
        }
        return super.create(modelClass)
    }
}