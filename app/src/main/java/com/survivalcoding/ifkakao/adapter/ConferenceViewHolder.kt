package com.survivalcoding.ifkakao.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.survivalcoding.ifkakao.databinding.ItemConferenceBinding
import com.survivalcoding.ifkakao.extension.getStringExceptTags
import com.survivalcoding.ifkakao.model.Conference

class ConferenceViewHolder(private val binding: ItemConferenceBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Conference) {
        binding.apply {
            title.text = item.title.getStringExceptTags()
            field.text = item.field

            binding.thumbnail.load(item.linkList.mobileImage[0].url)
        }
    }
}