package com.example.ifkakao.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.ifkakao.R
import com.example.ifkakao.databinding.ItemSessionBinding
import com.example.ifkakao.model.jsonformat.Session

class SessionAdapter :
    ListAdapter<Session, SessionAdapter.SessionViewHolder>(SessionDiffUtilCallback()) {
    private lateinit var binding: ItemSessionBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        binding = ItemSessionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SessionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SessionViewHolder(private val binding: ItemSessionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Session) {
            binding.apply {
                sessionNameText.text =
                    HtmlCompat.fromHtml(item.title, HtmlCompat.FROM_HTML_MODE_LEGACY)
                categoryText.text = item.field
                thumbnailImage.load(item.linkList.mobileImage[0].url) {
                    crossfade(true)
                    placeholder(R.drawable.temp_thumbnail)
                    transformations(listOf(RoundedCornersTransformation(5f)))
                }
                videoLengthText.text = item.linkList.video[0].description
            }
        }
    }
}