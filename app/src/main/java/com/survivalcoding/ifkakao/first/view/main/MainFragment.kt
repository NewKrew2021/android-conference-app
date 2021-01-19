package com.survivalcoding.ifkakao.first.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentMainBinding
import com.survivalcoding.ifkakao.first.view.MainActivity.Companion.MAIN_TO_DETAIL
import com.survivalcoding.ifkakao.first.view.detail.DetailFragment
import com.survivalcoding.ifkakao.first.view.main.adapter.ConferenceMainAdapter
import com.survivalcoding.ifkakao.first.viewmodel.ConferenceViewModel


class MainFragment(private val viewModel: ConferenceViewModel) : Fragment() {
    private var _binding: FragmentMainBinding? = null
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
        adapter.submitList(viewModel.getData())
    }
}