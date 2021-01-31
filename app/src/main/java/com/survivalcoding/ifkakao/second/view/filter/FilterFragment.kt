package com.survivalcoding.ifkakao.second.view.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.survivalcoding.ifkakao.databinding.SecondFragmentFilterBinding
import com.survivalcoding.ifkakao.second.model.filter.FilterType
import com.survivalcoding.ifkakao.second.viewmodel.FilterViewModel

class FilterFragment : Fragment() {
    private var _binding: SecondFragmentFilterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FilterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SecondFragmentFilterBinding.inflate(inflater, container, false).apply {
            fragment = this@FilterFragment
            lifecycleOwner = this@FilterFragment
            viewmodel = viewModel
        }
        requireActivity().title = "if(kakao)2020"
        binding.resetButton.setOnClickListener { viewModel.resetFilter() }
        binding.submitButton.setOnClickListener {
            val action = FilterFragmentDirections.actionFilterToMain(viewModel.filters.value)
            findNavController().navigate(action)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun filterClickListener(type: FilterType, name: String) {
        val isChecked = viewModel.isSelectedFilter(type, name)
        if (isChecked) viewModel.removeFilter(type)
        else viewModel.addFilter(type, name)
    }
}