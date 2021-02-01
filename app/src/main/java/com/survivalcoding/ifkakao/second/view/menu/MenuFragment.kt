package com.survivalcoding.ifkakao.second.view.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.survivalcoding.ifkakao.databinding.SecondFragmentMenuBinding
import com.survivalcoding.ifkakao.second.viewmodel.FilterViewModel

class MenuFragment : Fragment() {
    private var _binding: SecondFragmentMenuBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FilterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SecondFragmentMenuBinding.inflate(inflater, container, false).apply {
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}