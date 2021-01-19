package com.jayden.ifkakaoclone.view.main.holder

import androidx.core.text.HtmlCompat
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
            textTitle.text = item.title?.takeIf { it.isNotEmpty() }?.let {
                HtmlCompat.fromHtml(item.title, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
            } ?: ""
            textVideoLength.text = item.linkList?.video?.takeIf { it.isNotEmpty() }?.get(0)?.description ?: ""

            item.linkList?.pcImage?.takeIf { it.isNotEmpty() }?.get(0)?.url?.let {
                thumbnail.load(it) {
                    placeholder(R.drawable.image_placeholder)
                }
            }
        }
    }
}