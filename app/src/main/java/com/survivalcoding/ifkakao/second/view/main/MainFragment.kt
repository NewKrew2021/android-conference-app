package com.survivalcoding.ifkakao.second.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.survivalcoding.ifkakao.databinding.SecondFragmentMainBinding
import com.survivalcoding.ifkakao.second.model.ContentData
import com.survivalcoding.ifkakao.second.view.main.adapter.ContentMainAdapter
import com.survivalcoding.ifkakao.second.viewmodel.ContentViewModel


class MainFragment : Fragment() {
    private var _binding: SecondFragmentMainBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy {
        ContentMainAdapter(itemClickListener = {
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SecondFragmentMainBinding.inflate(inflater, container, false)
        requireActivity().title = "if(kakao)2020"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        val viewModel: ContentViewModel by viewModels()
        viewModel.data.observe(viewLifecycleOwner) {
            updateUI(it)
        }
        viewModel.loadData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateUI(data: List<ContentData>) {
        adapter.submitList(data)
    }

}