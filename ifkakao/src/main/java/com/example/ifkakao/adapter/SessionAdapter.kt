package com.example.ifkakao.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ifkakao.databinding.ItemSessionBinding
import com.example.ifkakao.databinding.SessionListFooterBinding
import com.example.ifkakao.model.jsonformat.Session

// TODO: Footer 제
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
            itemCount -> TYPE_FOOTER
            else -> TYPE_ITEM
        }
    }

    class SessionFooterViewHolder(private val binding: SessionListFooterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setOnclickListener(scrollUpListener: (View) -> Unit) {
            binding.scrollUpButton.setOnClickListener(scrollUpListener)
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
    }
}