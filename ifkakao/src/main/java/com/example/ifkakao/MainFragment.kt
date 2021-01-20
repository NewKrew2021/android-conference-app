package com.example.ifkakao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ifkakao.adapter.SessionAdapter
import com.example.ifkakao.databinding.FragmentMainBinding
import com.example.ifkakao.model.ConferenceRepository
import com.example.ifkakao.model.Repository

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: SessionAdapter
    private val repository: Repository = ConferenceRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
    }

    private fun initializeView() {
        adapter = SessionAdapter(repository.getConferenceData().data)
        binding.conferenceRecyclerView.adapter = adapter
        updateList()
    }

    private fun updateList() {
        adapter.submitList(repository.getConferenceData().data.toList())
    }
}