package com.survivalcoding.ifkakao.ifkakao.view.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.survivalcoding.ifkakao.databinding.ItemFooterBinding
import com.survivalcoding.ifkakao.databinding.ItemPresenterBinding
import com.survivalcoding.ifkakao.ifkakao.model.speakermodel.PresenterInfo

class PresentationAdapter() :
    ListAdapter<PresenterInfo, RecyclerView.ViewHolder>(PresentationDiffCallback) {

    private val TYPE_ITEM = 1
    private val TYPE_FOOTER = 2

    class PresentationViewHolder(private val binding: ItemPresenterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binding(item: PresenterInfo) {
            binding.presenter = item
        }
    }

    private lateinit var binding: ItemPresenterBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_FOOTER -> FooterViewHolder(
                ItemFooterBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> {
                binding =
                    ItemPresenterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                PresentationViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = getItem(holder.adapterPosition)
        when (holder) {
            is FooterViewHolder -> {
                holder.setListener()
            }
            is PresentationViewHolder -> {
                holder.binding(data)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        Log.d("TAG", "onBindViewHolder: itemCount : ${itemCount}")
        return when (position) {
            itemCount - 1 -> TYPE_FOOTER
            else -> TYPE_ITEM
        }
    }


    class FooterViewHolder(private val binding: ItemFooterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setListener() {
            Log.d("TAG", "setListener: up button onclicked")
            binding.scrollUpButton.setOnClickListener { itemView.scrollTo(0, 0)}
        }
    }
}
