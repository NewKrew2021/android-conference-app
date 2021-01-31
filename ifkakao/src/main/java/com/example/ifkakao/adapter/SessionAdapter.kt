package com.example.ifkakao.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ifkakao.databinding.ItemSessionBinding
import com.example.ifkakao.databinding.SessionListFooterBinding
import com.example.ifkakao.model.jsonformat.Session

class SessionAdapter(
    private val sessionClickListener: (Session) -> Unit,
    private val upButtonClickListener: (View) -> Unit
) :
    ListAdapter<Session, RecyclerView.ViewHolder>(SessionDiffUtilCallback()) {
    private lateinit var binding: ItemSessionBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_FOOTER -> SessionFooterViewHolder(
                SessionListFooterBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
            else -> {
                binding =
                    ItemSessionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                SessionViewHolder(binding, sessionClickListener)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is SessionViewHolder -> {
                holder.bind(getItem(position))
                holder.setOnclickListener(getItem(position))
            }
            is SessionFooterViewHolder -> {
                holder.setOnclickListener(upButtonClickListener)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            itemCount - 1 -> TYPE_FOOTER
            else -> TYPE_ITEM
        }
    }

    fun setItemList(list: List<Session>) {
        val tempList = list.toMutableList()
        if (list.isNotEmpty()) {
            tempList.add(list[0])
        }
        submitList(tempList)
    }

    class SessionFooterViewHolder(private val binding: SessionListFooterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setOnclickListener(scrollUpListener: (View) -> Unit) {
            binding.apply {
                scrollUpButton.setOnClickListener(scrollUpListener)
                ifKakaoDev2019.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW).apply {
                        val uri = Uri.parse(IF_KAKAO_2019)
                        data = uri;
                    }
                    startActivity(binding.root.context, intent, null)
                }
            }
        }
    }

    class SessionViewHolder(
        private val binding: ItemSessionBinding,
        private val sessionClickListener: (Session) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(session: Session) {
            binding.session = session
        }

        fun setOnclickListener(item: Session) {
            binding.root.setOnClickListener {
                sessionClickListener(item)
            }
        }
    }

    companion object {
        const val TYPE_ITEM = 1
        const val TYPE_FOOTER = 2
        const val IF_KAKAO_2019 = "https://if.kakao.com/2019"
    }
}