package com.jayden.ifkakaoclone.view.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jayden.ifkakaoclone.data.repository.Repository
import com.jayden.ifkakaoclone.data.viewmodel.SessionViewModel
import com.jayden.ifkakaoclone.databinding.FragmentSessionListBinding
import com.jayden.ifkakaoclone.view.main.adapter.SessionListAdapter

class SessionListFragment(repository: Repository) : Fragment() {
    private var _binding: FragmentSessionListBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel = SessionViewModel(repository)

    private val adapter by lazy {
        SessionListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSessionListBinding.inflate(inflater, container, false)
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
        updateUi()
    }

    private fun updateUi() {
        adapter.setItems(viewModel.getSessions())
        adapter.notifyDataSetChanged()
    }
}