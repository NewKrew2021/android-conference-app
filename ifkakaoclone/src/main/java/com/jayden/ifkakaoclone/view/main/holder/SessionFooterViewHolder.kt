package com.jayden.ifkakaoclone.view.main.holder

import androidx.recyclerview.widget.RecyclerView
import com.jayden.ifkakaoclone.databinding.SessionFooterLayoutBinding

class SessionFooterViewHolder(private val binding: SessionFooterLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(openWebUrl: () -> Unit, scrollToTop: () -> Unit) {
        binding.textIfkakao2019.setOnClickListener {
            openWebUrl.invoke()
        }
        binding.imageScrollTop.setOnClickListener {
            scrollToTop.invoke()
        }
    }
}