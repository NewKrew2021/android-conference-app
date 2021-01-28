package com.survivalcoding.ifkakao.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.survivalcoding.ifkakao.databinding.*
import com.survivalcoding.ifkakao.model.ConferenceAppFront
import com.survivalcoding.ifkakao.model.DetailRecyclerType
import com.survivalcoding.ifkakao.model.SpeackerInfo

private val TYPE_HEADER = 0
private val TYPE_FOOTER = 1
private val TYPE_ITEM = 2
private val TYPE_RELATIVE = 3
private val TYPE_LINKER = 4

class SpeakerRecyclerAdapter(
    val relativeStartIndex: Int,
    val itemClick: (ConferenceAppFront) -> Unit,
    val backItemClick: (Int) -> Unit,
    val favoritesClick: (RecyclerHeaderBinding, ConferenceAppFront) -> Unit,
    val setFavoritesButton: (RecyclerHeaderBinding, ConferenceAppFront) -> Unit,
    val facebookClickListner: (LinkItemBinding, ConferenceAppFront) -> Unit,
    val kakaoClickListener: (LinkItemBinding, ConferenceAppFront) -> Unit,
    val copyClickListener: (LinkItemBinding, ConferenceAppFront) -> Unit,
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
            return HeaderHolder(recyclerHeaderBinding, favoritesClick, setFavoritesButton)
        } else if (viewType == TYPE_RELATIVE) {
            val relativeItemBinding =
                RelativeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return RelativeHolder(relativeItemBinding, itemClick)
        } else if (viewType == TYPE_LINKER) {
            val linkItemrBinding =
                LinkItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return LinkerHolder(
                linkItemrBinding,
                facebookClickListner,
                kakaoClickListener,
                copyClickListener
            )
        }
        val speakerInfoBinding =
            SpeakerInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return SpeakerHolder(speakerInfoBinding)
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) return TYPE_HEADER
        else if (position == relativeStartIndex - 1) return TYPE_FOOTER
        else if (position == relativeStartIndex - 2) return TYPE_LINKER
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
        } else if (holder is LinkerHolder) {
            holder.clickListener(getItem(holder.adapterPosition) as ConferenceAppFront)
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

class LinkerHolder(
    val binding: LinkItemBinding,
    val facebookClickListner: (LinkItemBinding, ConferenceAppFront) -> Unit,
    val kakaoClickListener: (LinkItemBinding, ConferenceAppFront) -> Unit,
    val copyClickListener: (LinkItemBinding, ConferenceAppFront) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun clickListener(data: ConferenceAppFront) {

        binding.facebookButton.setOnClickListener {
            facebookClickListner(binding, data)
        }
        binding.kakaoButton.setOnClickListener {
            kakaoClickListener(binding, data)
        }
        binding.copyToClipboardButton.setOnClickListener {
            copyClickListener(binding, data)
        }
    }

}

class ButtonHolder(
    val binding: ButtonItemBinding,
    val backItemClick: (Int) -> Unit,
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
    val favoritesClick: (RecyclerHeaderBinding, ConferenceAppFront) -> Unit,
    val setFavoritesButton: (RecyclerHeaderBinding, ConferenceAppFront) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun setData(data: ConferenceAppFront) {
        binding.user = data

        setFavoritesButton(binding, data)

    }

    fun clickListener(data: ConferenceAppFront) {
        binding.likeToggleButton.setOnClickListener {
            favoritesClick(binding, data)
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