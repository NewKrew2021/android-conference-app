package com.survivalcoding.ifkakao.second.view.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.second.model.ContentData

object ContentMainDiffCallback : DiffUtil.ItemCallback<ContentData>() {
    override fun areItemsTheSame(oldItem: ContentData, newItem: ContentData): Boolean {
        return oldItem.idx == newItem.idx
    }

    override fun areContentsTheSame(oldItem: ContentData, newItem: ContentData): Boolean {
        return oldItem == newItem
    }
}