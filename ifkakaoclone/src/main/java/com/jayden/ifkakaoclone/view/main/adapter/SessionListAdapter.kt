package com.jayden.ifkakaoclone.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jayden.ifkakaoclone.databinding.SessionItemLayoutBinding
import com.jayden.ifkakaoclone.view.main.holder.SessionViewHolder
import com.jayden.ifkakaoclone.view.main.model.Session

class SessionListAdapter(
    private val selectSessionEvent: (session: Session) -> Unit
) : RecyclerView.Adapter<SessionViewHolder>() {

    private val items = mutableListOf<Session>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        val binding = SessionItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SessionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        holder.bind(items[holder.adapterPosition], selectSessionEvent)
    }

    override fun getItemCount(): Int = items.size

    fun setItems(newItems: List<Session>) {
        items.clear()
        items.addAll(newItems)
    }
}