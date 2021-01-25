package com.jayden.ifkakaoclone.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.jayden.ifkakaoclone.databinding.SessionItemLayoutBinding
import com.jayden.ifkakaoclone.view.main.holder.SessionViewHolder
import com.jayden.ifkakaoclone.view.main.model.Session

class SessionListAdapter(
    private val selectSessionEvent: (session: Session) -> Unit
) : ListAdapter<Session, SessionViewHolder>(SESSION_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        val binding =
            SessionItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SessionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        holder.bind(getItem(position), selectSessionEvent)
    }

    companion object {
        private val SESSION_COMPARATOR = object : DiffUtil.ItemCallback<Session>() {
            override fun areItemsTheSame(oldItem: Session, newItem: Session): Boolean =
                oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: Session, newItem: Session): Boolean =
                oldItem == newItem
        }
    }
}