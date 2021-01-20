package com.survivalcoding.ifkakao.ifkakao.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
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
        val item = getItem(holder.adapterPosition)
        binding.apply {
            field.text = item.field
            title.text = item.title

            // 일단 그냥 이미지 붙이기
//            thumbnail.setImageURI(item.linkList.MO_IMAGE[0].url.toUri())
        }
    }

}