package com.jayden.ifkakaoclone.view.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.chip.Chip
import com.jayden.ifkakaoclone.databinding.FragmentFilterDetailBinding
import com.jayden.ifkakaoclone.extensions.finish
import com.jayden.ifkakaoclone.viewmodel.SessionViewModel

class FilterDetailFragment : Fragment() {
    private var _binding: FragmentFilterDetailBinding? = null
    private val binding
        get() = _binding!!

    private val activityViewModel: SessionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilterDetailBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@FilterDetailFragment
            viewModel = activityViewModel
            fragment = this@FilterDetailFragment
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        with(binding) {
            imageClose.setOnClickListener { finish() }
        }
    }

    fun onFilterChipClicked(view: View, field: String) {
        val chip = view as Chip
        if (chip.isChecked) activityViewModel.addFilter(field)
        else activityViewModel.removeFilter(field)
    }

    fun applyFiltersThenFinish() {
        activityViewModel.applyFilters()
        finish()
    }
}