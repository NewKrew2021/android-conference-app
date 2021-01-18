package com.survivalcoding.ifkakao.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.survivalcoding.ifkakao.databinding.ItemConferenceBinding
import com.survivalcoding.ifkakao.model.SampleItem

class ConferenceAdapter : ListAdapter<SampleItem, ConferenceViewHolder>(ConferenceDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConferenceViewHolder {
        val binding =
            ItemConferenceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConferenceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConferenceViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}