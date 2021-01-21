package com.survivalcoding.ifkakao.adapter

import androidx.recyclerview.widget.RecyclerView
import com.survivalcoding.ifkakao.databinding.ItemConferenceBinding
import com.survivalcoding.ifkakao.model.Conference

class ConferenceViewHolder(private val binding: ItemConferenceBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Conference) {
        binding.conference = item.apply { trimData() }
    }
}