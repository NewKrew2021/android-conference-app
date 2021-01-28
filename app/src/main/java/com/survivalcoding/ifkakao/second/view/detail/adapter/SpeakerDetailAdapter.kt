package com.survivalcoding.ifkakao.second.view.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.SecondItemDetailHeaderBinding
import com.survivalcoding.ifkakao.databinding.SecondItemSpeakerBinding
import com.survivalcoding.ifkakao.second.model.content.*
import com.survivalcoding.ifkakao.second.model.favorite.database.Favorite
import com.survivalcoding.ifkakao.second.view.detail.holder.SpeakerDetailHolder

class SpeakerDetailAdapter(
    private val contentData: ContentData,
    private val favorite: Favorite,
    private val videoPlayListener: (String) -> Unit,
    private val favoriteClickListener: (Favorite) -> Unit,
) :
    ListAdapter<DetailViewType, SpeakerDetailHolder>(SpeakerDetailDiffCallback) {
    private val VIEW_TYPE_HEADER = 0
    private val VIEW_TYPE_ITEM = 1
    private val VIEW_TYPE_FOOTER = 2
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
            VIEW_TYPE_FOOTER -> {
                throw ClassCastException("Unknown ViewType")
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
                holder.binding.speaker = speakerItem as Speaker
                holder.binding.linkfile = fileItem
                holder.binding.executePendingBindings()

            }
            is SecondItemDetailHeaderBinding -> {
                holder.binding.contentdata = contentData
                holder.binding.playButton.setOnClickListener { videoPlayListener.invoke(contentData.linkList.video[0].url) }
                holder.binding.favoriteImage.setImageResource(if (favorite.isFavorite) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24)
                holder.binding.favoriteImage.setOnClickListener {
                    favoriteClickListener.invoke(favorite.apply { isFavorite = !isFavorite })
                    holder.binding.favoriteImage.setImageResource(if (favorite.isFavorite) R.drawable.ic_baseline_favorite_24 else R.drawable.ic_baseline_favorite_border_24)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DetailHeader -> VIEW_TYPE_HEADER
            is Speaker -> VIEW_TYPE_ITEM
            is DetailFooter -> VIEW_TYPE_FOOTER
        }
    }

    fun submitListWithHeader(data: List<Speaker>) {
        submitList(listOf(DetailHeader(0)) + data)
    }
}