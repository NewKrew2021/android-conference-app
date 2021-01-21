package com.survivalcoding.ifkakao.second.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import coil.ImageLoader
import coil.api.load
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.SecondItemContentBinding
import com.survivalcoding.ifkakao.second.model.ContentData
import com.survivalcoding.ifkakao.second.view.main.holder.ContentMainHolder

class ContentMainAdapter(
    private val itemClickListener: (item: ContentData) -> Unit,
    private val imageLoader: ImageLoader
) :
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
        holder.binding.contentdata = item
        holder.binding.thumbnailImage.load(item.linkList.pcImage[0].url, imageLoader)
    }
}