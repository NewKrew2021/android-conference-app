package com.survivalcoding.ifkakao.ifkakao.view.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.ifkakao.model.Data

object IfKakaoDiffCallback : DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.idx == newItem.idx
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }
}