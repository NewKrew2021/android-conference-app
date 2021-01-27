package com.survivalcoding.ifkakao.second.view.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.second.model.content.MainViewType

object ContentMainDiffCallback : DiffUtil.ItemCallback<MainViewType>() {
    override fun areItemsTheSame(oldItem: MainViewType, newItem: MainViewType): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MainViewType, newItem: MainViewType): Boolean {
        return oldItem == newItem
    }
}