package com.jayden.ifkakaoclone.view.main.holder

import androidx.recyclerview.widget.RecyclerView
import com.jayden.ifkakaoclone.databinding.SessionItemLayoutBinding
import com.jayden.ifkakaoclone.view.main.model.Session

class SessionViewHolder(private val binding: SessionItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Session) {
        binding.session = item
    }
}