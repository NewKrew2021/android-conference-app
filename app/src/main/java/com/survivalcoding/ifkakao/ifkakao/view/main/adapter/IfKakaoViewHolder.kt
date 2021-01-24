package com.survivalcoding.ifkakao.ifkakao.view.main.adapter

import androidx.recyclerview.widget.RecyclerView
import com.survivalcoding.ifkakao.databinding.ItemIfKakaoBinding
import com.survivalcoding.ifkakao.ifkakao.model.Data

class IfKakaoViewHolder(private val binding: ItemIfKakaoBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Data) {
        // DataBinding item_if_kakao.xml의 itemData에 매개변수로 온 item을 대입한다.
        // 그럼 binding.apply해서 일일이 데이터를 주입하지 않아도 된다.
        binding.itemData = item
    }
}