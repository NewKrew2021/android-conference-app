package com.survivalcoding.ifkakao.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.survivalcoding.ifkakao.databinding.ItemSpeakerBinding
import com.survivalcoding.ifkakao.model.Speaker

class SpeakerAdapter : ListAdapter<Speaker, SpeakerViewHolder>(SpeakerDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeakerViewHolder {
        return SpeakerViewHolder(
            ItemSpeakerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SpeakerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}