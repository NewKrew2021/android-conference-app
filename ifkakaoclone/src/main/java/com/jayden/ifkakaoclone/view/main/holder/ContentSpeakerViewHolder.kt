package com.jayden.ifkakaoclone.view.main.holder

import androidx.recyclerview.widget.RecyclerView
import com.jayden.ifkakaoclone.databinding.ContentSpeakerLayoutBinding
import com.jayden.ifkakaoclone.view.main.model.ContentsSpeakerWithLink

class ContentSpeakerViewHolder(private val binding: ContentSpeakerLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(speaker: ContentsSpeakerWithLink) {
        binding.item = speaker
    }
}