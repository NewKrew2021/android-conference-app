package com.survivalcoding.ifkakao.first.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FirstFragmentMainBinding
import com.survivalcoding.ifkakao.first.model.Conference
import com.survivalcoding.ifkakao.first.view.MainActivity.Companion.MAIN_TO_DETAIL
import com.survivalcoding.ifkakao.first.view.detail.DetailFragment
import com.survivalcoding.ifkakao.first.view.main.adapter.ConferenceMainAdapter
import com.survivalcoding.ifkakao.first.viewmodel.ConferenceViewModel


class MainFragment : Fragment() {
    private var _binding: FirstFragmentMainBinding? = null
    private val binding get() = _binding!!
    private val adapter by lazy {
        ConferenceMainAdapter(itemClickListener = {
            val bundle = bundleOf(MAIN_TO_DETAIL to it)
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace<DetailFragment>(R.id.fragment_container_view, args = bundle)
                addToBackStack(null)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FirstFragmentMainBinding.inflate(inflater, container, false)
        requireActivity().title = "Conference List"
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        val viewModel: ConferenceViewModel by viewModels()
        viewModel.data.observe(viewLifecycleOwner) {
            updateUI(it)
        }
        viewModel.loadData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateUI(data: List<Conference>) {
        adapter.submitList(data)
    }
}