package com.survivalcoding.ifkakao.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.survivalcoding.ifkakao.databinding.SpeakerInfoBinding
import com.survivalcoding.ifkakao.model.SpeackerInfo

class SpeakerRecyclerAdapter(

) :
    ListAdapter<SpeackerInfo, SpeakerHolder>(SpeakerDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeakerHolder {
        val speakerInfoBinding =
            SpeakerInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return SpeakerHolder(speakerInfoBinding)
    }

    override fun onBindViewHolder(holder: SpeakerHolder, position: Int) {
        holder.setData(getItem(holder.adapterPosition))
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