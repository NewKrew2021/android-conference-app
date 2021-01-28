package com.survivalcoding.ifkakao.second.view.detail.adapter

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.second.model.content.DetailViewType

object SpeakerDetailDiffCallback : DiffUtil.ItemCallback<DetailViewType>() {
    override fun areItemsTheSame(oldItem: DetailViewType, newItem: DetailViewType): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DetailViewType, newItem: DetailViewType): Boolean {
        return oldItem == newItem
    }
}