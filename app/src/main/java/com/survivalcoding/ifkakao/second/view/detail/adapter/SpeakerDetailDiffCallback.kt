package com.survivalcoding.ifkakao.second.view.detail.adapter

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.second.model.content.Speaker

object SpeakerDetailDiffCallback : DiffUtil.ItemCallback<Speaker>() {
    override fun areItemsTheSame(oldItem: Speaker, newItem: Speaker): Boolean {
        return oldItem.idx == newItem.idx
    }

    override fun areContentsTheSame(oldItem: Speaker, newItem: Speaker): Boolean {
        return oldItem == newItem
    }
}