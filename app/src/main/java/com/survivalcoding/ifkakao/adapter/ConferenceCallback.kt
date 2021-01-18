package com.survivalcoding.ifkakao.adapter

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.model.ConferenceItem

object ConferenceCallback : DiffUtil.ItemCallback<ConferenceItem>() {
    override fun areItemsTheSame(oldItem: ConferenceItem, newItem: ConferenceItem): Boolean {
        return oldItem.link == newItem.link
    }

    override fun areContentsTheSame(oldItem: ConferenceItem, newItem: ConferenceItem): Boolean {
        return oldItem == newItem
    }


}