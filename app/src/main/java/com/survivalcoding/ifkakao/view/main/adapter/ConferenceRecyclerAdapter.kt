package com.survivalcoding.ifkakao.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.survivalcoding.ifkakao.databinding.ItemConferenceBinding
import com.survivalcoding.ifkakao.model.Data
import com.survivalcoding.ifkakao.view.main.holder.ConferenceViewHolder

class ConferenceRecyclerAdapter(private val clickListener: (data: Data) -> Unit) :
    ListAdapter<Data, ConferenceViewHolder>(ConferenceDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConferenceViewHolder {
        val binding = ItemConferenceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ConferenceViewHolder(binding)

        binding.root.setOnClickListener {
            clickListener.invoke(getItem(holder.adapterPosition))
        }
        return holder
    }

    override fun onBindViewHolder(holder: ConferenceViewHolder, position: Int) {
        holder.binding.data = getItem(position)
    }
}