package com.jayden.ifkakaoclone.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jayden.ifkakaoclone.databinding.ContentSpeakerLayoutBinding
import com.jayden.ifkakaoclone.view.main.holder.ContentSpeakerViewHolder
import com.jayden.ifkakaoclone.view.main.model.ContentsSpeacker
import com.jayden.ifkakaoclone.view.main.model.Link

class ContentSpeakerAdapter : RecyclerView.Adapter<ContentSpeakerViewHolder>() {

    private val items = mutableListOf<Pair<ContentsSpeacker, Link>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentSpeakerViewHolder {
        val binding = ContentSpeakerLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContentSpeakerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContentSpeakerViewHolder, position: Int) {
        holder.bind(items[holder.adapterPosition])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(newItems: List<Pair<ContentsSpeacker, Link>>) {
        items.clear()
        items.addAll(newItems)
    }
}