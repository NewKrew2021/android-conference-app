package com.survivalcoding.ifkakao.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.model.ConferenceAppFront
import com.survivalcoding.ifkakao.model.DetailRecyclerType
import com.survivalcoding.ifkakao.model.SpeackerInfo


object SpeakerDiffCallback : DiffUtil.ItemCallback<DetailRecyclerType>() {
    override fun areItemsTheSame(
        oldItem: DetailRecyclerType,
        newItem: DetailRecyclerType
    ): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(
        oldItem: DetailRecyclerType,
        newItem: DetailRecyclerType
    ): Boolean {
        if (oldItem is ConferenceAppFront) {
            return oldItem as ConferenceAppFront == newItem as ConferenceAppFront
        }

        return oldItem as SpeackerInfo == newItem as SpeackerInfo
    }
}