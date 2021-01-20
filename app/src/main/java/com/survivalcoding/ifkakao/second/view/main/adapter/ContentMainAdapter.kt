package com.survivalcoding.ifkakao.second.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.SecondItemContentBinding
import com.survivalcoding.ifkakao.second.model.ContentData
import com.survivalcoding.ifkakao.second.view.main.holder.ContentMainHolder

class ContentMainAdapter(private val itemClickListener: (item: ContentData) -> Unit) :
    ListAdapter<ContentData, ContentMainHolder>(ContentMainDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentMainHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.second_item_content, parent, false)
        val binding = SecondItemContentBinding.bind(view)
        val holder = ContentMainHolder(binding)
        binding.root.setOnClickListener { itemClickListener.invoke(getItem(holder.adapterPosition)) }
        return holder
    }

    override fun onBindViewHolder(holder: ContentMainHolder, position: Int) {
        val item = getItem(position)
        holder.binding.titleText.text = item.title
        holder.binding.fieldText.text = item.field
        holder.binding.descriptionText.text = item.linkList.video[0].description
    }
}