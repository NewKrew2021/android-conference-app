package com.survivalcoding.ifkakao.adapter

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.model.Conferences

object ConferenceCallback : DiffUtil.ItemCallback<Conferences>() {
    override fun areItemsTheSame(oldItem: Conferences, newItem: Conferences): Boolean {
        return oldItem.link == newItem.link
    }

    override fun areContentsTheSame(oldItem: Conferences, newItem: Conferences): Boolean {
        return oldItem == newItem
    }


}