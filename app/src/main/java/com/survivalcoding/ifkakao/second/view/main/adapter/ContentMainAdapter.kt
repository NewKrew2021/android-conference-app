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
import com.survivalcoding.ifkakao.second.model.filter.Filter
import com.survivalcoding.ifkakao.second.view.main.holder.ContentMainHolder

class ContentMainAdapter(
    private var selectedDate: Int = -1,
    private val itemClickListener: (item: ContentData) -> Unit,
    private val filterClickListener: () -> Unit,
    private val spinnerArrayAdapter: ArrayAdapter<CharSequence>,
    private val spinnerChangeListener: (Int) -> Unit,

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
                spinnerArrayAdapter.also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    binding.filterSpinner.adapter = adapter
                }
                if (selectedDate != -1) binding.filterSpinner.setSelection(3 - selectedDate)
                binding.filterSpinner.onItemSelectedListener =
                    object : AdapterView.OnItemSelectedListener {
                        override fun onNothingSelected(parent: AdapterView<*>?) {
                        }

                        override fun onItemSelected(
                            parent: AdapterView<*>?,
                            view: View?,
                            position: Int,
                            id: Long
                        ) {
                            selectedDate = 3 - position
                            spinnerChangeListener.invoke(selectedDate)
                        }
                    }
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
                if (selectedDate != -1) {
                    holder.binding.filterText.visibility = View.INVISIBLE
                    holder.binding.filterSpinner.visibility = View.VISIBLE
                    holder.binding.showButton.visibility = View.INVISIBLE
                    holder.binding.filterButton.visibility = View.VISIBLE
                } else {
                    holder.binding.filterText.visibility = View.VISIBLE
                    holder.binding.filterSpinner.visibility = View.INVISIBLE
                    holder.binding.showButton.visibility = View.VISIBLE
                    holder.binding.filterButton.visibility = View.INVISIBLE
                }
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

    fun submitListWithHeader(data: List<ContentData>, filter: Filter) {
        submitList(listOf(MainHeader(0)) + data.filter {
            filter.data.containsValue(it.field) || filter.data.isEmpty()
        })
    }
}