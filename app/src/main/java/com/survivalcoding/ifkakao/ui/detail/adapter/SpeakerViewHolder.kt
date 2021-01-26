package com.survivalcoding.ifkakao.ui.detail.adapter

import androidx.recyclerview.widget.RecyclerView
import com.survivalcoding.ifkakao.databinding.ItemSpeakerBinding
import com.survivalcoding.ifkakao.model.Speaker

class SpeakerViewHolder(private val binding: ItemSpeakerBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(speaker: Speaker) {
        binding.speaker = speaker
    }
}