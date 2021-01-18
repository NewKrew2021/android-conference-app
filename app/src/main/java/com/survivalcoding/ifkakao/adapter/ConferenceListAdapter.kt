package com.survivalcoding.ifkakao.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.survivalcoding.ifkakao.databinding.ConferenceItemBinding
import com.survivalcoding.ifkakao.holder.ConferenceListViewHolder
import com.survivalcoding.ifkakao.model.ConferenceItem

class ConferenceListAdapter :
    ListAdapter<ConferenceItem, ConferenceListViewHolder>(ConferenceCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConferenceListViewHolder {
        val binding = ConferenceItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConferenceListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConferenceListViewHolder, position: Int) {
        val currentItem = getItem(holder.adapterPosition)
        holder.binding.apply {
            name.text = currentItem.name
            link.text = currentItem.link
            start.text = currentItem.start
            end.text = currentItem.end
            location.text = currentItem.location
        }
    }
}