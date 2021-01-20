package com.example.ifkakao

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.ifkakao.adapter.SessionAdapter
import com.example.ifkakao.databinding.FragmentMainBinding
import com.example.ifkakao.viewmodel.SessionViewModel

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SessionViewModel by viewModels()
    private lateinit var adapter: SessionAdapter

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
        observeData()
    }

    private fun initializeView() {
        adapter = SessionAdapter()
        binding.conferenceRecyclerView.adapter = adapter
        viewModel.updateSessionData()
    }

    private fun observeData() {
        viewModel.apply {
            sessionList.observe(viewLifecycleOwner) {
                adapter.updateList(it.toList())
            }
        }
    }
}