package com.example.ifkakao.adapter

import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
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
    private var sessionList: List<Session> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionViewHolder {
        binding = ItemSessionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SessionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SessionViewHolder, position: Int) {
        holder.bind(sessionList[position])
    }

    fun updateList(sessionList: List<Session>) {
        this.sessionList = sessionList
        submitList(sessionList)
    }

    class SessionViewHolder(private val binding: ItemSessionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Session) {
            binding.apply {
                // html <br> 태그 처리를 위한 버전 분기
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    sessionNameText.text = Html.fromHtml(item.title, Html.FROM_HTML_MODE_LEGACY)
                } else {
                    sessionNameText.text = Html.fromHtml(item.title)
                }
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