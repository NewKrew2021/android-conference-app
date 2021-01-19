package com.survivalcoding.ifkakao.adapter

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.model.Conferences
import com.survivalcoding.ifkakao.model.conferenceData.Data

object ConferenceCallback : DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.idx == newItem.idx
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }


}