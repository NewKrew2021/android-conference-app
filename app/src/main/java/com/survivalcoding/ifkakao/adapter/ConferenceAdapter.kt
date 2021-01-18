package com.survivalcoding.ifkakao.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.survivalcoding.ifkakao.databinding.ItemConferenceBinding
import com.survivalcoding.ifkakao.model.ConferenceInfo
import com.survivalcoding.ifkakao.model.Repository
import com.survivalcoding.ifkakao.viewmodel.ConferenceViewModel

class ConferenceAdapter(
    private val viewModel: ConferenceViewModel,
    private val itemClickListener: (ConferenceInfo) -> Unit
) :
    RecyclerView.Adapter<ConferenceAdapter.ConferenceViewHolder>() {
    private lateinit var binding: ItemConferenceBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConferenceViewHolder {
        binding = ItemConferenceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConferenceViewHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: ConferenceViewHolder, position: Int) {
        holder.bind(viewModel.getConferenceData()[position])
    }

    override fun getItemCount(): Int = viewModel.getConferenceData().size

    class ConferenceViewHolder(
        private val binding: ItemConferenceBinding,
        private val itemClickListener: (ConferenceInfo) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ConferenceInfo) {
            binding.apply {
                nameText.text = item.name
                locationText.text = item.location
                root.setOnClickListener {
                    itemClickListener(item)
                }
            }
        }
    }
}