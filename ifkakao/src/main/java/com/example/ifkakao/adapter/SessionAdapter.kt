package com.example.ifkakao.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ifkakao.R
import com.example.ifkakao.databinding.ItemSessionBinding
import com.example.ifkakao.model.jsonformat.Session

class SessionAdapter(private val sessionList: List<Session>) :
    ListAdapter<Session, SessionAdapter.SessionViewHolder>(SessionDiffUtilCallback()) {
    private lateinit var binding: ItemSessionBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        binding = ItemSessionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SessionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        holder.bind(sessionList[position])
    }

    class SessionViewHolder(private val binding: ItemSessionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Session) {
            binding.apply {
                sessionNameText.text = item.title
                categoryText.text = item.field
                // 임시로 이미지 넣어둠
                thumbnailImage.setImageDrawable(
                    ResourcesCompat.getDrawable(
                        binding.root.resources,
                        R.drawable.temp_thumbnail,
                        null
                    )
                )
                thumbnailImage.clipToOutline = true
                videoLengthText.text = item.linkList.video[0].description
            }
        }
    }
}