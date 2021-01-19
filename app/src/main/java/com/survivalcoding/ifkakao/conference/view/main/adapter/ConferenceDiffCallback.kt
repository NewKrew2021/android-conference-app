package com.survivalcoding.ifkakao.conference.view.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.conference.data.DataModelItem

object ConferenceDiffCallback : DiffUtil.ItemCallback<DataModelItem>() {
    override fun areItemsTheSame(oldItem: DataModelItem, newItem: DataModelItem): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: DataModelItem, newItem: DataModelItem): Boolean {
        return oldItem == newItem
    }

}