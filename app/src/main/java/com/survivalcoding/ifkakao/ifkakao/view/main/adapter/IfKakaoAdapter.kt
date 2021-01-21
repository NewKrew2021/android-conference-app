package com.survivalcoding.ifkakao.ifkakao.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.survivalcoding.ifkakao.databinding.ItemIfKakaoBinding
import com.survivalcoding.ifkakao.ifkakao.model.Data

class IfKakaoAdapter() : ListAdapter<Data, IfKakaoViewHolder>(IfKakaoDiffCallback) {

    private lateinit var binding: ItemIfKakaoBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IfKakaoViewHolder {
        binding = ItemIfKakaoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IfKakaoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IfKakaoViewHolder, position: Int) {
        holder.bind(getItem(holder.adapterPosition))
    }

}