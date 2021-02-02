package com.survivalcoding.ifkakao.second.view.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.survivalcoding.ifkakao.databinding.SecondFragmentMenuBinding
import com.survivalcoding.ifkakao.second.model.filter.Filter

class MenuFragment : Fragment() {
    private var _binding: SecondFragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SecondFragmentMenuBinding.inflate(inflater, container, false).apply {
        }
        binding.sessionButton.setOnClickListener {
            val action = MenuFragmentDirections.actionMenuToMain(Filter(mapOf()))
            findNavController().navigate(action)
        }
        binding.highlightButton.setOnClickListener {
            val action = MenuFragmentDirections.actionMenuToMain()
            findNavController().navigate(action)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}