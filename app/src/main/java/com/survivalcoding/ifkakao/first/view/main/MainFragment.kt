package com.survivalcoding.ifkakao.first.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentMainBinding
import com.survivalcoding.ifkakao.first.model.repository.Repository
import com.survivalcoding.ifkakao.first.view.detail.DetailFragment
import com.survivalcoding.ifkakao.first.view.main.adapter.ConferenceMainAdapter


class MainFragment(private val repository: Repository) : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy {
        ConferenceMainAdapter(itemClickListener = {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<DetailFragment>(R.id.fragment_container_view)
                addToBackStack(null)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        requireActivity().title = "Conference List"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        updateUI()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateUI() {
        adapter.submitList(repository.getData())
    }
}