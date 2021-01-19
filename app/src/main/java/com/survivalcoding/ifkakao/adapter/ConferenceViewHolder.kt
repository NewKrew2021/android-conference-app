package com.survivalcoding.ifkakao.adapter

import androidx.recyclerview.widget.RecyclerView
import com.survivalcoding.ifkakao.databinding.ItemConferenceBinding
import com.survivalcoding.ifkakao.model.Conference

class ConferenceViewHolder(private val binding: ItemConferenceBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Conference) {
        binding.apply {
            name.text = item.idx.toString()
            location.text = item.title
        }
    }
}