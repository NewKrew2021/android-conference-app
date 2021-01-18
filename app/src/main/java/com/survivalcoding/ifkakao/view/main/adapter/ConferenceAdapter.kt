package com.survivalcoding.ifkakao.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.survivalcoding.ifkakao.databinding.ConferenceItemLayoutBinding
import com.survivalcoding.ifkakao.view.main.holder.ConferenceViewHolder
import com.survivalcoding.ifkakao.view.main.model.Conference

class ConferenceAdapter : RecyclerView.Adapter<ConferenceViewHolder>() {

    private val items = mutableListOf<Conference>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConferenceViewHolder {
        val binding =
            ConferenceItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConferenceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConferenceViewHolder, position: Int) {
        holder.bind(items[holder.adapterPosition])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(newItems: List<Conference>) {
        items.clear()
        items.addAll(newItems)
    }
}