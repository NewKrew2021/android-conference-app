package com.jayden.ifkakaoclone.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.jayden.ifkakaoclone.databinding.ContentSpeakerLayoutBinding
import com.jayden.ifkakaoclone.view.main.holder.ContentSpeakerViewHolder
import com.jayden.ifkakaoclone.view.main.model.ContentsSpeakerWithLink

class ContentSpeakerAdapter :
    ListAdapter<ContentsSpeakerWithLink, ContentSpeakerViewHolder>(SPEAKER_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentSpeakerViewHolder {
        val binding =
            ContentSpeakerLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContentSpeakerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContentSpeakerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val SPEAKER_COMPARATOR = object : DiffUtil.ItemCallback<ContentsSpeakerWithLink>() {
            override fun areItemsTheSame(
                oldItem: ContentsSpeakerWithLink,
                newItem: ContentsSpeakerWithLink
            ): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(
                oldItem: ContentsSpeakerWithLink,
                newItem: ContentsSpeakerWithLink
            ): Boolean =
                oldItem == newItem

        }
    }
}