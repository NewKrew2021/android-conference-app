package com.example.ifkakao.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.ifkakao.model.jsonformat.Session

class SessionDiffUtilCallback : DiffUtil.ItemCallback<Session>() {
    override fun areItemsTheSame(oldItem: Session, newItem: Session): Boolean {
        return oldItem.idx == newItem.idx
    }

    override fun areContentsTheSame(oldItem: Session, newItem: Session): Boolean {
        return oldItem == newItem
    }
}