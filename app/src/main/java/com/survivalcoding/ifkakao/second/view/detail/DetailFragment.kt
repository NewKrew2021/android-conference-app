package com.survivalcoding.ifkakao.second.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.survivalcoding.ifkakao.databinding.SecondFragmentDetailBinding
import com.survivalcoding.ifkakao.second.model.Speaker
import com.survivalcoding.ifkakao.second.view.detail.adapter.SpeakerDetailAdapter
import com.survivalcoding.ifkakao.second.viewmodel.ContentViewModel


class DetailFragment : Fragment() {
    private var _binding: SecondFragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ContentViewModel by activityViewModels()
    private val adapter by lazy {
        SpeakerDetailAdapter(contentData = viewModel.selectedItem)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SecondFragmentDetailBinding.inflate(inflater, container, false)
        requireActivity().title = "if(kakao)2020"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        viewModel.speakers.observe(viewLifecycleOwner) {
            updateUI(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateUI(data: List<Speaker>) {
        adapter.submitList(data)
    }

}