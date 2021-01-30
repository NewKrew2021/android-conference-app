package com.survivalcoding.ifkakao.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.survivalcoding.ifkakao.databinding.FrontItemBinding
import com.survivalcoding.ifkakao.model.ConferenceAppFront

private val TYPE_HEADER = 0
private val TYPE_ITEM = 1

class RecyclerAdapter(
    val itemClick: (ConferenceAppFront) -> Unit
) :
    ListAdapter<ConferenceAppFront, RecyclerView.ViewHolder>(ItemDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        /*
        if (viewType == TYPE_HEADER) {
            val recyclerHeaderBinding =
                RecyclerHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return HeaderViewHolder(recyclerHeaderBinding)
        }
         */

        val frontItemBinding =
            FrontItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(frontItemBinding, itemClick)
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) return TYPE_HEADER
        else return TYPE_ITEM
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is Holder) {
            holder.setData(getItem(holder.adapterPosition))
            holder.clickListener(getItem(holder.adapterPosition))
        }
    }
}

class Holder(
    val binding: FrontItemBinding,
    val itemClick: (ConferenceAppFront) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun setData(data: ConferenceAppFront) {
        binding.lengthTextView.text = data.videoLength
        binding.fieldTextView.text = data.field
        binding.titleTextView.text = data.title
        binding.imageView.load(data.imageUrl) {
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
