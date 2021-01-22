package com.jayden.ifkakaoclone.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jayden.ifkakaoclone.databinding.SessionFilterLayoutBinding
import com.jayden.ifkakaoclone.databinding.SessionItemLayoutBinding
import com.jayden.ifkakaoclone.view.main.holder.SessionFilterViewHolder
import com.jayden.ifkakaoclone.view.main.holder.SessionViewHolder
import com.jayden.ifkakaoclone.view.main.model.Session

private const val VIEW_TYPE_HEADER = 0
private const val VIEW_TYPE_ITEM = 1

class SessionListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items = mutableListOf<SessionView>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_HEADER -> {
                val binding = SessionFilterLayoutBinding.inflate(layoutInflater, parent, false)
                SessionFilterViewHolder(binding)
            }
            VIEW_TYPE_ITEM -> {
                val binding = SessionItemLayoutBinding.inflate(layoutInflater, parent, false)
                SessionViewHolder(binding)
            }
            else -> throw ClassCastException("Unknown ViewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SessionViewHolder -> {
                val sessionItem = items[holder.adapterPosition] as SessionView.Item
                holder.bind(sessionItem.item)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int = items[position].getRecyclerType()

    fun addHeaderAndSetItems(newItems: List<Session>) {
        val mappedItem = listOf(SessionView.Header) + newItems.map { SessionView.Item(it) }
        items.clear()
        items.addAll(mappedItem)
    }
}

sealed class SessionView {
    data class Item(val item: Session) : SessionView() {
        override fun getRecyclerType(): Int = VIEW_TYPE_ITEM
    }

    object Header : SessionView() {
        override fun getRecyclerType(): Int = VIEW_TYPE_HEADER
    }

    abstract fun getRecyclerType(): Int
}