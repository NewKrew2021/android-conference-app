package com.example.ifkakao.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ifkakao.databinding.ItemSessionBinding
import com.example.ifkakao.databinding.SessionListFooterBinding
import com.example.ifkakao.databinding.SessionListHeaderBinding
import com.example.ifkakao.model.jsonformat.Session

class SessionAdapter :
    ListAdapter<Session, RecyclerView.ViewHolder>(SessionDiffUtilCallback()) {
    private lateinit var binding: ItemSessionBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> SessionHeaderViewHolder(
                SessionListHeaderBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
            TYPE_FOOTER -> SessionFooterViewHolder(
                SessionListFooterBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
            else -> {
                binding =
                    ItemSessionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                SessionViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SessionViewHolder) {
            binding.session = getItem(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_HEADER
            itemCount - 1 -> TYPE_FOOTER
            else -> TYPE_ITEM
        }
    }

    class SessionHeaderViewHolder(binding: SessionListHeaderBinding) :
        RecyclerView.ViewHolder(binding.root)

    class SessionFooterViewHolder(binding: SessionListFooterBinding) :
        RecyclerView.ViewHolder(binding.root)

    class SessionViewHolder(binding: ItemSessionBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_ITEM = 1
        const val TYPE_FOOTER = 2
    }
}