package com.survivalcoding.ifkakao.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.survivalcoding.ifkakao.data.model.response.ConferenceContentsSpeakerResponse
import com.survivalcoding.ifkakao.data.model.response.ConferenceDetailResponse
import com.survivalcoding.ifkakao.databinding.ItemSpeakerBinding


class SpeakerAdapter : RecyclerView.Adapter<SpeakerViewHolder>() {

    private var speakerList: MutableList<ConferenceContentsSpeakerResponse> = ArrayList()
    private var speakerImageList: MutableList<ConferenceDetailResponse> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeakerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSpeakerBinding.inflate(inflater, parent, false)
        return SpeakerViewHolder(binding)
    }

    override fun getItemCount(): Int = speakerList.size

    override fun onBindViewHolder(holder: SpeakerViewHolder, position: Int) {
        holder.bindView(speakerList[position], speakerImageList[position])
    }

    fun setList(
        speakerList: List<ConferenceContentsSpeakerResponse>,
        imageList: List<ConferenceDetailResponse>
    ) {
        this.speakerList = speakerList as MutableList<ConferenceContentsSpeakerResponse>
        this.speakerImageList = imageList as MutableList<ConferenceDetailResponse>
    }
}


class SpeakerViewHolder(private val binding: ItemSpeakerBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindView(speaker: ConferenceContentsSpeakerResponse, image: ConferenceDetailResponse) {
        binding.tvNameSpeaker.text = speaker.nameKo
        binding.tvCompanySpeaker.text = speaker.company
        binding.tvOccupationSpeaker.text = speaker.occupation

        Glide.with(binding.ivSpeaker)
            .load(image.url)
            .fitCenter()
            .into(binding.ivSpeaker)
    }
}