package com.survivalcoding.ifkakao.view.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.model.Data

object ConferenceDiffCallback : DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.idx == newItem.idx
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }
}