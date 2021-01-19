package com.survivalcoding.ifkakao.first.view.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.first.model.Conference

object ConferenceMainDiffCallback : DiffUtil.ItemCallback<Conference>() {
    override fun areItemsTheSame(oldItem: Conference, newItem: Conference): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Conference, newItem: Conference): Boolean {
        return oldItem == newItem
    }
}