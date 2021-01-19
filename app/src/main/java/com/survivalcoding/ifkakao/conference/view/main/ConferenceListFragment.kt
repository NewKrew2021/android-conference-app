package com.survivalcoding.ifkakao.conference.view.main

import android.app.ActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.survivalcoding.ifkakao.conference.data.DataModelItem
import com.survivalcoding.ifkakao.conference.view.main.adapter.ConferenceAdapter
import com.survivalcoding.ifkakao.databinding.FragmentConferenceListBinding

class ConferenceListFragment(private val data : List<DataModelItem>) : Fragment() {
    private var _binding: FragmentConferenceListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConferenceListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ConferenceAdapter()
        binding.apply {
            conferenceList.adapter = adapter
        }
        adapter.submitList(data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}