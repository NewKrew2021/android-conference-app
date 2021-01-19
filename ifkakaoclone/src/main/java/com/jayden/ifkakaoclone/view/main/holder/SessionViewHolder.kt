package com.jayden.ifkakaoclone.view.main.holder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.jayden.ifkakaoclone.R
import com.jayden.ifkakaoclone.databinding.SessionItemLayoutBinding
import com.jayden.ifkakaoclone.view.main.model.Session

class SessionViewHolder(private val binding: SessionItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Session) {
        with(binding) {
            textField.text = item.field ?: ""
            textTitle.text = item.title ?: ""

            item.linkList?.pcImage?.takeIf { it.isNotEmpty() }?.get(0)?.url?.let {
                thumbnail.load(it) {
                    placeholder(R.drawable.image_placeholder)
                }
            }

            item.linkList?.video?.takeIf { it.isNotEmpty() }?.get(0)?.description?.let {
                textVideoLength.text = it
            }
        }
    }
}