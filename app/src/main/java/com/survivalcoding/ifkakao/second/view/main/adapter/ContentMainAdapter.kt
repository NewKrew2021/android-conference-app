package com.survivalcoding.ifkakao.second.view.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.ListAdapter
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.SecondItemContentBinding
import com.survivalcoding.ifkakao.databinding.SecondItemMainHeaderBinding
import com.survivalcoding.ifkakao.second.model.content.ContentData
import com.survivalcoding.ifkakao.second.model.content.MainHeader
import com.survivalcoding.ifkakao.second.model.content.MainViewType
import com.survivalcoding.ifkakao.second.view.main.holder.ContentMainHolder

class ContentMainAdapter(
    private val itemClickListener: (item: ContentData) -> Unit,
    private val filterClickListener: () -> Unit,
    private val spinnerArrayAdapter: ArrayAdapter<CharSequence>,
    private val spinnerChangeListener: AdapterView.OnItemSelectedListener,

    ) :
    ListAdapter<MainViewType, ContentMainHolder>(ContentMainDiffCallback) {
    private val VIEW_TYPE_HEADER = 0
    private val VIEW_TYPE_ITEM = 1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentMainHolder {
        return when (viewType) {
            VIEW_TYPE_ITEM -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.second_item_content, parent, false)
                val binding = SecondItemContentBinding.bind(view)
                val holder = ContentMainHolder(binding)
                binding.root.setOnClickListener { itemClickListener.invoke(getItem(holder.adapterPosition) as ContentData) }
                holder
            }
            VIEW_TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.second_item_main_header, parent, false)
                val binding = SecondItemMainHeaderBinding.bind(view)
                val holder = ContentMainHolder(binding)
                binding.showButton.setOnClickListener {
                    binding.filterText.visibility = View.INVISIBLE
                    binding.filterSpinner.visibility = View.VISIBLE
                    binding.showButton.visibility = View.INVISIBLE
                    binding.filterButton.visibility = View.VISIBLE
                }
                binding.filterButton.setOnClickListener { filterClickListener.invoke() }
                binding.filterButton.visibility = View.INVISIBLE
                binding.filterSpinner.visibility = View.INVISIBLE
                spinnerArrayAdapter.also { adapter ->
                    // Specify the layout to use when the list of choices appears
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    // Apply the adapter to the spinner
                    binding.filterSpinner.adapter = adapter
                }
                binding.filterSpinner.onItemSelectedListener = spinnerChangeListener
                holder
            }
            else -> {
                throw ClassCastException("Unknown ViewType")
            }
        }
    }

    override fun onBindViewHolder(holder: ContentMainHolder, position: Int) {
        when (holder.binding) {
            is SecondItemContentBinding -> {
                val item = getItem(position)
                holder.binding.contentdata = item as ContentData
                holder.binding.executePendingBindings()

            }
            is SecondItemMainHeaderBinding -> {

            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is MainHeader -> VIEW_TYPE_HEADER
            is ContentData -> VIEW_TYPE_ITEM
        }
    }

    fun submitListWithHeader(data: List<ContentData>) {
        submitList(listOf(MainHeader(0)) + data)
    }
}