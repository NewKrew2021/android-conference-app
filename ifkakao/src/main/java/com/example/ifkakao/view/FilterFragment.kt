package com.example.ifkakao.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ifkakao.R
import com.example.ifkakao.databinding.FragmentFilterBinding
import com.example.ifkakao.viewmodel.SessionViewModel

class FilterFragment : Fragment() {
    private var _binding: FragmentFilterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SessionViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilterBinding.inflate(inflater, container, false)
        return binding.let {
            it.lifecycleOwner = this
            it.fragment = this
            it.viewModel = viewModel
            it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData(view)
        binding.root.setOnClickListener {}
    }

    private fun observeData(view: View) {
        viewModel.apply {
            selectedFilter.observe(viewLifecycleOwner) { filters ->
                filters.forEach {
                    view.findViewById<TextView>(it).apply {
                        setTextColor(ResourcesCompat.getColor(resources, R.color.black, null))
                        background = ResourcesCompat.getDrawable(
                            resources,
                            R.drawable.filter_item_selected,
                            null
                        )
                    }
                }
                setClearButton(filters)
            }
            removedFilter.observe(viewLifecycleOwner) {
                if (it == SessionViewModel.NO_FILTER_ID) return@observe
                view.findViewById<TextView>(it).apply {
                    setTextColor(
                        ResourcesCompat.getColor(
                            resources,
                            R.color.filter_item_color,
                            null
                        )
                    )
                    background = ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.filter_item_border,
                        null
                    )
                }
            }
        }
    }

    private fun setClearButton(filters: Set<Int>) {
        val buttonText = getString(R.string.clear)
        binding.clearButton.apply {
            text =
                if (filters.isEmpty()) buttonText else "$buttonText(${filters.size})"
        }
    }

    fun onAcceptButtonClick(v: View) {
        viewModel.applyFilter()
        parentFragmentManager.popBackStack()
    }

    fun onFilterButtonClick(v: View) = viewModel.setFilter(v.id)

    fun onClearButtonClick(v: View) = viewModel.clearFilter()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}