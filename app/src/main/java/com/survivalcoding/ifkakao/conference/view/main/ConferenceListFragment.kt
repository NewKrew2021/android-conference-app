package com.survivalcoding.ifkakao.conference.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.conference.data.DataModelItem
import com.survivalcoding.ifkakao.conference.view.conference.ConferenceFragment
import com.survivalcoding.ifkakao.conference.view.main.adapter.ConferenceAdapter
import com.survivalcoding.ifkakao.databinding.FragmentConferenceListBinding
import androidx.fragment.app.replace

class ConferenceListFragment(private val data: List<DataModelItem>) : Fragment() {
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
        val adapter = ConferenceAdapter(listener = listener)
        requireActivity().title = "Conferences"
        binding.apply {
            conferenceList.adapter = adapter
        }
        adapter.submitList(data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val listener = fun(index: Int) {
        val bundle = bundleOf("index" to index)
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace<ConferenceFragment>(R.id.conference_fragment, args = bundle)
            addToBackStack(null)
        }
    }
}