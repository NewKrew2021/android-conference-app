package com.survivalcoding.ifkakao.second.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.SecondItemContentBinding
import com.survivalcoding.ifkakao.databinding.SecondItemMainHeaderBinding
import com.survivalcoding.ifkakao.second.model.ContentData
import com.survivalcoding.ifkakao.second.view.main.holder.ContentMainHolder

class ContentMainAdapter(
    private val itemClickListener: (item: ContentData) -> Unit,
    private val filterClickListener: () -> Unit,
) :
    ListAdapter<ContentData, ContentMainHolder>(ContentMainDiffCallback) {
    private val VIEW_TYPE_HEADER = 0
    private val VIEW_TYPE_ITEM = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentMainHolder {
        return when (viewType) {
            VIEW_TYPE_ITEM -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.second_item_content, parent, false)
                val binding = SecondItemContentBinding.bind(view)
                val holder = ContentMainHolder(binding)
                binding.root.setOnClickListener { itemClickListener.invoke(getItem(holder.adapterPosition)) }
                holder
            }
            VIEW_TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.second_item_main_header, parent, false)
                val binding = SecondItemMainHeaderBinding.bind(view)
                val holder = ContentMainHolder(binding)
                binding.filterButton.setOnClickListener { filterClickListener.invoke() }
                holder
            }
            else -> {
                throw ClassCastException("Unknown ViewType")
            }
        }
    }

    override fun onBindViewHolder(holder: ContentMainHolder, position: Int) {
        when (holder.binding) {
            is SecondItemContentBinding -> {
                val item = getItem(position)
                holder.binding.contentdata = item
                holder.binding.executePendingBindings()

            }
            is SecondItemMainHeaderBinding -> {

            }
        }
    }

    override fun getItem(position: Int): ContentData {
        return super.getItem(position - 1)
    }

    override fun getItemViewType(position: Int) =
        if (position == 0) VIEW_TYPE_HEADER else VIEW_TYPE_ITEM

    override fun getItemCount(): Int {
        return super.getItemCount() + 1
    }
}