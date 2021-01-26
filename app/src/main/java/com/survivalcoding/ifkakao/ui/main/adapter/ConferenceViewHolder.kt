package com.survivalcoding.ifkakao.ui.main.adapter

import androidx.recyclerview.widget.RecyclerView
import com.survivalcoding.ifkakao.databinding.ItemConferenceBinding
import com.survivalcoding.ifkakao.model.Session

class ConferenceViewHolder(private val binding: ItemConferenceBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Session) {
        binding.session = item
    }
}