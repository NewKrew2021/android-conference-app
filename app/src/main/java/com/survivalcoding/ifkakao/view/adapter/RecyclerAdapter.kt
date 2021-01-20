package com.survivalcoding.ifkakao.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.survivalcoding.ifkakao.databinding.FrontItemBinding
import com.survivalcoding.ifkakao.model.ConferenceAppFront

class RecyclerAdapter(
    val itemClick: (Int) -> Unit
) :
    ListAdapter<ConferenceAppFront, Holder>(ItemDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val frontItemBinding =
            FrontItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(frontItemBinding, itemClick)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setData(getItem(holder.adapterPosition))
        holder.clickListener()
    }
}

class Holder(
    val binding: FrontItemBinding,
    val itemClick: (Int) -> Unit
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

    fun clickListener() {
        binding.constraintLayout.setOnClickListener {
            itemClick(adapterPosition)
        }
    }
}