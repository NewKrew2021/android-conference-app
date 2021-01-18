package com.survivalcoding.ifkakao.adapter

import androidx.recyclerview.widget.RecyclerView
import com.survivalcoding.ifkakao.databinding.ItemConferenceBinding
import com.survivalcoding.ifkakao.model.SampleItem

class ConferenceViewHolder(private val binding: ItemConferenceBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: SampleItem) {
        binding.apply {
            name.text = item.name
            location.text = item.location
        }
    }
}