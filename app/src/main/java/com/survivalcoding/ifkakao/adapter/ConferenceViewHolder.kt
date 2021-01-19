package com.survivalcoding.ifkakao.adapter

import androidx.recyclerview.widget.RecyclerView
import com.survivalcoding.ifkakao.databinding.ItemConferenceBinding
import com.survivalcoding.ifkakao.model.Conference

class ConferenceViewHolder(private val binding: ItemConferenceBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Conference) {
        binding.apply {
            title.text = trimmedString(item.title)
            field.text = item.field
        }
    }

    private fun trimmedString(origin: String) = androidx.core.text.HtmlCompat.fromHtml(
        origin,
        androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY
    )
}