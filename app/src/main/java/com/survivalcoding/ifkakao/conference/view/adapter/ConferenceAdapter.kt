package com.survivalcoding.ifkakao.conference.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.survivalcoding.ifkakao.conference.data.DataModelItem
import com.survivalcoding.ifkakao.databinding.ItemConferenceBinding

class ConferenceAdapter(private val dataSet: List<DataModelItem>) :
    ListAdapter<DataModelItem, ConferenceViewHolder>(ConferenceDiffCallback) {

    private lateinit var binding: ItemConferenceBinding

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ConferenceViewHolder {
        binding =
            ItemConferenceBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        dataSet?.let {
            binding.apply {
                conferenceName.text = dataSet[0].name
                conferenceLocation.text = dataSet[0].location
            }
        }
        return ConferenceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConferenceViewHolder, position: Int) {
        binding.apply {
            conferenceName.text = dataSet[position].name
            conferenceLocation.text = dataSet[position].location
        }
    }
}
