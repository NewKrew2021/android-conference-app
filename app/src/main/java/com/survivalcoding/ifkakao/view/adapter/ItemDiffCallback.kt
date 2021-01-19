package com.survivalcoding.ifkakao.view.adapter

import android.content.ClipData
import androidx.recyclerview.widget.DiffUtil
import com.survivalcoding.ifkakao.model.ConferenceAppFront

object ItemDiffCallback : DiffUtil.ItemCallback<ConferenceAppFront>() {
    override fun areItemsTheSame(oldItem: ConferenceAppFront, newItem: ConferenceAppFront): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem:ConferenceAppFront, newItem: ConferenceAppFront): Boolean {
        return oldItem == newItem
    }
}