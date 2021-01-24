package com.survivalcoding.ifkakao.ifkakao.view.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.ifkakao.model.speakermodel.PresenterInfo

object PresentationDiffCallback : DiffUtil.ItemCallback<PresenterInfo>() {
    override fun areItemsTheSame(oldItem: PresenterInfo, newItem: PresenterInfo): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: PresenterInfo, newItem: PresenterInfo): Boolean {
        return oldItem == newItem
    }
}