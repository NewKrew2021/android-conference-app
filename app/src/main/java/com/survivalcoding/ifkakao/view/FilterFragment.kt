package com.survivalcoding.ifkakao.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.survivalcoding.ifkakao.databinding.FragmentFilterBinding
import com.survivalcoding.ifkakao.viewmodel.FilterViewModel


class FilterFragment : Fragment() {
    private var _bindng: FragmentFilterBinding? = null
    private val binding get() = _bindng!!
    val viewModel: FilterViewModel by activityViewModels()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _bindng = FragmentFilterBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindng = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModels = viewModel
        binding.lifecycleOwner = requireActivity()
    }
}