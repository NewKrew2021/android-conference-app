package com.survivalcoding.ifkakao.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.model.SpeackerInfo


object SpeakerDiffCallback : DiffUtil.ItemCallback<SpeackerInfo>() {
    override fun areItemsTheSame(oldItem: SpeackerInfo, newItem: SpeackerInfo): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: SpeackerInfo, newItem: SpeackerInfo): Boolean {
        return oldItem == newItem
    }
}