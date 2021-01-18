package com.survivalcoding.ifkakao.view.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.data.repository.Repository
import com.survivalcoding.ifkakao.data.viewmodel.ConferenceViewModel
import com.survivalcoding.ifkakao.databinding.FragmentConferenceListBinding
import com.survivalcoding.ifkakao.view.main.adapter.ConferenceAdapter

class ConferenceListFragment(repository: Repository) : Fragment() {
    private var _binding: FragmentConferenceListBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        ConferenceAdapter()
    }

    private val viewModel = ConferenceViewModel(repository)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentConferenceListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            recyclerView.adapter = adapter
            recyclerView.addItemDecoration(
                DividerItemDecoration(
                    context,
                    LinearLayoutManager.VERTICAL
                )
            )
        }
        updateUI()
    }

    private fun updateUI() {
        adapter.setItems(viewModel.getItems())
        adapter.notifyDataSetChanged()
    }
}