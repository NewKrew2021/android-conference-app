package com.survivalcoding.ifkakao.second.view.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.SecondItemDetailHeaderBinding
import com.survivalcoding.ifkakao.databinding.SecondItemSpeakerBinding
import com.survivalcoding.ifkakao.second.model.ContentData
import com.survivalcoding.ifkakao.second.model.Speaker
import com.survivalcoding.ifkakao.second.view.detail.holder.SpeakerDetailHolder

class SpeakerDetailAdapter(
    private val contentData: ContentData,
    private val videoPlayListener: (String) -> Unit
) :
    ListAdapter<Speaker, SpeakerDetailHolder>(SpeakerDetailDiffCallback) {
    private val VIEW_TYPE_HEADER = 0
    private val VIEW_TYPE_ITEM = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeakerDetailHolder {
        return when (viewType) {
            VIEW_TYPE_ITEM -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.second_item_speaker, parent, false)
                val binding = SecondItemSpeakerBinding.bind(view)
                val holder = SpeakerDetailHolder(binding)
                holder
            }
            VIEW_TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.second_item_detail_header, parent, false)
                val binding = SecondItemDetailHeaderBinding.bind(view)
                val holder = SpeakerDetailHolder(binding)
                holder
            }
            else -> {
                throw ClassCastException("Unknown ViewType")
            }
        }
    }

    override fun onBindViewHolder(holder: SpeakerDetailHolder, position: Int) {
        when (holder.binding) {
            is SecondItemSpeakerBinding -> {
                val speakerItem = getItem(position)
                val fileItem = contentData.linkList.speackerProfile[holder.adapterPosition - 1]
                holder.binding.speaker = speakerItem
                holder.binding.linkfile = fileItem
                holder.binding.executePendingBindings()

            }
            is SecondItemDetailHeaderBinding -> {
                holder.binding.contentdata = contentData
                holder.binding.playButton.setOnClickListener { videoPlayListener.invoke(contentData.linkList.video[0].url) }
            }
        }
    }

    override fun getItem(position: Int): Speaker {
        return super.getItem(position - 1)
    }

    override fun getItemViewType(position: Int) =
        if (position == 0) VIEW_TYPE_HEADER else VIEW_TYPE_ITEM

    override fun getItemCount(): Int {
        return super.getItemCount() + 1
    }
}