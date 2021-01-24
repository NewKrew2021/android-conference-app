package com.jayden.ifkakaoclone.view.main.holder

import androidx.recyclerview.widget.RecyclerView
import com.jayden.ifkakaoclone.databinding.SessionItemLayoutBinding
import com.jayden.ifkakaoclone.view.main.model.Session

class SessionViewHolder(private val binding: SessionItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Session, showSessionDetail: (Session) -> Unit) {
        binding.session = item
        binding.executePendingBindings()    // UI 스레드에서 강제로 바인딩 반영 (다음 화면이 보여지기 전에)

        itemView.setOnClickListener {
            showSessionDetail.invoke(item)
        }
    }
}