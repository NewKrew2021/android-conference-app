package com.survivalcoding.ifkakao.ifkakao.view.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.survivalcoding.ifkakao.databinding.ItemPresenterBinding
import com.survivalcoding.ifkakao.ifkakao.model.speakermodel.PresenterInfo

class PresentationAdapter() :
    ListAdapter<PresenterInfo, PresentationAdapter.PresentationViewHolder>(PresentationDiffCallback) {

    class PresentationViewHolder(private val binding: ItemPresenterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binding(item: PresenterInfo) {
            binding.presenter = item
        }
    }

    private lateinit var binding: ItemPresenterBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PresentationViewHolder {
        binding = ItemPresenterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PresentationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PresentationViewHolder, position: Int) {
        val data = getItem(holder.adapterPosition)
        holder.binding(data)
    }
}