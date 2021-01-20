package com.survivalcoding.ifkakao.second.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.survivalcoding.ifkakao.databinding.SecondFragmentMainBinding


class MainFragment : Fragment() {
    private var _binding: SecondFragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SecondFragmentMainBinding.inflate(inflater, container, false)
        requireActivity().title = "if(kakao)2020"
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}