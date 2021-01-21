package com.survivalcoding.ifkakao.first.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FirstItemConferenceBinding
import com.survivalcoding.ifkakao.first.model.Conference
import com.survivalcoding.ifkakao.first.view.main.holder.ConferenceMainHolder

class ConferenceMainAdapter(private val itemClickListener: (item: Conference) -> Unit) :
    ListAdapter<Conference, ConferenceMainHolder>(ConferenceMainDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConferenceMainHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.first_item_conference, parent, false)
        val binding = FirstItemConferenceBinding.bind(view)
        val holder = ConferenceMainHolder(binding)
        binding.root.setOnClickListener { itemClickListener.invoke(getItem(holder.adapterPosition)) }
        return holder
    }

    override fun onBindViewHolder(holder: ConferenceMainHolder, position: Int) {
        val item = getItem(position)
        holder.binding.conference = item
    }
}