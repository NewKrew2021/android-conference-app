package com.survivalcoding.ifkakao.adapter

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.model.Conference
import com.survivalcoding.ifkakao.model.SampleItem

object ConferenceDiffCallback : DiffUtil.ItemCallback<Conference>() {
    override fun areItemsTheSame(oldItem: Conference, newItem: Conference): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Conference, newItem: Conference): Boolean {
        return oldItem == newItem
    }

}