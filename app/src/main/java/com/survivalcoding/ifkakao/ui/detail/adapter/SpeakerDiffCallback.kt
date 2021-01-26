package com.survivalcoding.ifkakao.ui.detail.adapter

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.model.Speaker

object SpeakerDiffCallback : DiffUtil.ItemCallback<Speaker>() {
    override fun areItemsTheSame(oldItem: Speaker, newItem: Speaker): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Speaker, newItem: Speaker): Boolean {
        return oldItem == newItem
    }
}