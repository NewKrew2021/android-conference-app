package com.jayden.ifkakaoclone.view.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jayden.ifkakaoclone.data.repository.Repository
import com.jayden.ifkakaoclone.data.viewmodel.SessionViewModel
import com.jayden.ifkakaoclone.databinding.FragmentSessionListBinding

class SessionListFragment(repository: Repository) : Fragment() {
    private var _binding: FragmentSessionListBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel = SessionViewModel(repository)

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
}