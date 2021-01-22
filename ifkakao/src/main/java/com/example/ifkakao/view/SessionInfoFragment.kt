package com.example.ifkakao.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ifkakao.databinding.FragmentSessionInfoBinding
import com.example.ifkakao.viewmodel.SessionViewModel

/*
TODO: 1. Web View에 동영상 나오도록 구현
 */
class SessionInfoFragment : Fragment() {
    private var _binding: FragmentSessionInfoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SessionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSessionInfoBinding.inflate(inflater, container, false)
        return binding.let {
            it.lifecycleOwner = this
            it.viewModel = viewModel
            it.root
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}