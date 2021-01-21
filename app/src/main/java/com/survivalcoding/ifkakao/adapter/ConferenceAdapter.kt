package com.survivalcoding.ifkakao.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.survivalcoding.ifkakao.databinding.ItemConferenceBinding
import com.survivalcoding.ifkakao.model.Session

class ConferenceAdapter(
    private val itemClickListener: (Session) -> Unit,
) : ListAdapter<Session, ConferenceViewHolder>(ConferenceDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConferenceViewHolder {
        val binding =
            ItemConferenceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConferenceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConferenceViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            itemClickListener.invoke(getItem(position))
        }
    }
}