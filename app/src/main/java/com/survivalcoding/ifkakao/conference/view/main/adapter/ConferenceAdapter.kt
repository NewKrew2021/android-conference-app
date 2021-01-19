package com.survivalcoding.ifkakao.conference.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.survivalcoding.ifkakao.conference.data.DataModelItem
import com.survivalcoding.ifkakao.databinding.ItemConferenceBinding

class ConferenceAdapter(private val listener: (Int) -> Unit) :
    ListAdapter<DataModelItem, ConferenceViewHolder>(ConferenceDiffCallback) {

    private lateinit var binding: ItemConferenceBinding

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ConferenceViewHolder {
        binding =
            ItemConferenceBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ConferenceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConferenceViewHolder, position: Int) {
        val item = getItem(holder.adapterPosition)
        binding.apply {
            conferenceName.text = item.name
            conferenceLocation.text = item.location
            conferenceItem.setOnClickListener { listener.invoke(holder.adapterPosition) }
        }
    }
}
