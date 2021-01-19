package com.survivalcoding.ifkakao.conference.view.conference

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.conference.data.DataModelItem
import com.survivalcoding.ifkakao.databinding.FragmentConferenceBinding

class ConferenceFragment(private val data: List<DataModelItem>) :
    Fragment(R.layout.fragment_conference) {

    private var _binding: FragmentConferenceBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConferenceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val index = requireArguments().getInt("index")
        val item = data[index]

        requireActivity().title = item.name
        Log.d("TAG", "onBindViewHolder: item : ${item}, index : ${index}")

        binding.apply {
            location.text = item.location
            conferenceDate.text = "${item.start} ~ ${item.end}"
            conferenceWebsite.text = item.link
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}