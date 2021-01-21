package com.survivalcoding.ifkakao.first.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.survivalcoding.ifkakao.databinding.FirstFragmentDetailBinding
import com.survivalcoding.ifkakao.first.model.Conference
import com.survivalcoding.ifkakao.first.view.MainActivity


class DetailFragment : Fragment() {
    private var _binding: FirstFragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FirstFragmentDetailBinding.inflate(inflater, container, false)
        requireActivity().title = "Conference Detail"

        arguments?.getParcelable<Conference>(MainActivity.MAIN_TO_DETAIL)?.let {
            binding.conference = it
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}