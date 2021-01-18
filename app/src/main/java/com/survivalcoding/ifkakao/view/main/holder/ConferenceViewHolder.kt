package com.survivalcoding.ifkakao.view.main.holder

import androidx.recyclerview.widget.RecyclerView
import com.survivalcoding.ifkakao.databinding.ConferenceItemLayoutBinding
import com.survivalcoding.ifkakao.view.main.model.Conference

class ConferenceViewHolder(private val binding: ConferenceItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Conference, itemClickListener: (Conference) -> Unit) {
        with(binding) {
            textName.text = item.name
            textLocation.text = item.location

            itemLayout.setOnClickListener {
                itemClickListener.invoke(item)
            }
        }
    }
}