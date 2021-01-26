package com.survivalcoding.ifkakao.ui.main.adapter

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.model.Session

object ConferenceDiffCallback : DiffUtil.ItemCallback<Session>() {
    override fun areItemsTheSame(oldItem: Session, newItem: Session): Boolean {
        return oldItem.idx == newItem.idx
    }

    override fun areContentsTheSame(oldItem: Session, newItem: Session): Boolean {
        return oldItem == newItem
    }
}