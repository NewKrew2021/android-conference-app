package com.survivalcoding.ifkakao.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.survivalcoding.ifkakao.databinding.ButtonItemBinding
import com.survivalcoding.ifkakao.databinding.RecyclerHeaderBinding
import com.survivalcoding.ifkakao.databinding.RelativeItemBinding
import com.survivalcoding.ifkakao.databinding.SpeakerInfoBinding
import com.survivalcoding.ifkakao.model.ConferenceAppFront
import com.survivalcoding.ifkakao.model.DetailRecyclerType
import com.survivalcoding.ifkakao.model.SpeackerInfo
import com.survivalcoding.ifkakao.repository.FavoritesRepository

private val TYPE_HEADER = 0
private val TYPE_FOOTER = 1
private val TYPE_ITEM = 2
private val TYPE_RELATIVE = 3

class SpeakerRecyclerAdapter(
    val relativeStartIndex: Int,
    val itemClick: (ConferenceAppFront) -> Unit,
    val backItemClick: (Int) -> Unit,

    ) :
    ListAdapter<DetailRecyclerType, RecyclerView.ViewHolder>(SpeakerDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_FOOTER) {
            val buttonItemBinding =
                ButtonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ButtonHolder(buttonItemBinding, backItemClick)
        } else if (viewType == TYPE_HEADER) {
            val recyclerHeaderBinding =
                RecyclerHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return HeaderHolder(recyclerHeaderBinding)
        } else if (viewType == TYPE_RELATIVE) {
            val relativeItemBinding =
                RelativeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return RelativeHolder(relativeItemBinding, itemClick)
        }
        val speakerInfoBinding =
            SpeakerInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return SpeakerHolder(speakerInfoBinding)
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) return TYPE_HEADER
        else if (position == relativeStartIndex - 1) return TYPE_FOOTER
        else if (position >= relativeStartIndex) return TYPE_RELATIVE

        return TYPE_ITEM
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SpeakerHolder) {
            holder.setData(getItem(holder.adapterPosition) as SpeackerInfo)
        } else if (holder is HeaderHolder) {
            holder.setData(getItem(holder.adapterPosition) as ConferenceAppFront)
            holder.clickListener(getItem(holder.adapterPosition) as ConferenceAppFront)
        } else if (holder is RelativeHolder) {
            holder.setData(getItem(holder.adapterPosition) as ConferenceAppFront)
            holder.clickListener(getItem(holder.adapterPosition) as ConferenceAppFront)
        } else if (holder is ButtonHolder) {
            holder.clickListener()
        }

    }
}

class SpeakerHolder(
    val binding: SpeakerInfoBinding,
) :
    RecyclerView.ViewHolder(binding.root) {

    fun setData(data: SpeackerInfo) {

        binding.nameTextView.text = "${data.contentsSpeaker.nameKo} ${data.contentsSpeaker.nameEn}"
        binding.companyTextView.text = "${data.contentsSpeaker.company}"
        binding.occupationTextView.text = "${data.contentsSpeaker.occupation}"

        binding.imageView.load("${data.url}") {
            transformations(
                RoundedCornersTransformation(
                    topRight = 72f,
                    topLeft = 72f,
                    bottomLeft = 72f,
                    bottomRight = 72f
                )
            )
        }

    }
}

class ButtonHolder(
    val binding: ButtonItemBinding,
    var backItemClick: (Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {
    fun clickListener() {
        binding.button.setOnClickListener {
            backItemClick(3)
        }
    }

}

class HeaderHolder(
    val binding: RecyclerHeaderBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun setData(data: ConferenceAppFront) {
        binding.user = data
        if (FavoritesRepository.isExist(data.id)) {
            binding.likeToggleButton.isChecked = true
        } else {
            binding.likeToggleButton.isChecked = false
        }
    }

    fun clickListener(data: ConferenceAppFront) {
        binding.likeToggleButton.setOnClickListener {
            if (binding.likeToggleButton.isChecked == true) FavoritesRepository.addFavoritesItem(
                data.id
            )
            else FavoritesRepository.removeFavoritesItem(data.id)


        }
    }
}

class RelativeHolder(
    val binding: RelativeItemBinding,
    val itemClick: (ConferenceAppFront) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {

    fun setData(data: ConferenceAppFront) {
        binding.lengthTextView.text = "${data.videoLength}"
        binding.fieldTextView.text = "${data.field}"
        binding.titleTextView.text = "${data.title}"
        binding.imageView.load("${data.imageUrl}") {
            transformations(
                RoundedCornersTransformation(
                    topRight = 20f,
                    topLeft = 20f,
                    bottomLeft = 20f,
                    bottomRight = 20f
                )
            )
        }
    }

    fun clickListener(data: ConferenceAppFront) {
        binding.constraintLayout.setOnClickListener {
            itemClick(data)
        }
    }
}