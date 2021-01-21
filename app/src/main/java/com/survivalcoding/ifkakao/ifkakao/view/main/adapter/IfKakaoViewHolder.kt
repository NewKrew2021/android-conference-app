package com.survivalcoding.ifkakao.ifkakao.view.main.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.survivalcoding.ifkakao.databinding.ItemIfKakaoBinding
import com.survivalcoding.ifkakao.ifkakao.model.Data

class IfKakaoViewHolder(private val binding: ItemIfKakaoBinding) :
    RecyclerView.ViewHolder(binding.root) {
    // view holder에서 bind하니까 itemView로 view를 가져가 쓸 수 있다.
    fun bind(item: Data) {
        binding.apply {
            field.text = item.field
            title.text = item.title
            videoLength.text = item.linkList.VIDEO[0].description
        }

        // 테두리에 선을 넣어야 한다.
        val option = RequestOptions().transform(RoundedCorners(30))
        Glide.with(itemView).load(item.linkList.MO_IMAGE[0].url)
            .apply(option)
            .into(binding.thumbnail)
    }
}