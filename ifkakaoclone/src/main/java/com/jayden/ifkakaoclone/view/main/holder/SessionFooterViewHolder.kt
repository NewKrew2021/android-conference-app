package com.jayden.ifkakaoclone.view.main.holder

import androidx.recyclerview.widget.RecyclerView
import com.jayden.ifkakaoclone.databinding.SessionFooterLayoutBinding

class SessionFooterViewHolder(private val binding: SessionFooterLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(openIfKakao2019: () -> Unit, smoothScrollToTop: () -> Unit) {
        binding.textIfkakao2019.setOnClickListener {
            openIfKakao2019.invoke()
        }
        binding.imageScrollTop.setOnClickListener {
            smoothScrollToTop.invoke()
        }
    }
}