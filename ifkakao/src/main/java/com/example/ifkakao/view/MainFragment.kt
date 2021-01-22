package com.example.ifkakao.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.ifkakao.R
import com.example.ifkakao.adapter.SessionAdapter
import com.example.ifkakao.databinding.FragmentMainBinding
import com.example.ifkakao.util.replaceTransaction
import com.example.ifkakao.viewmodel.SessionViewModel

/*
TODO: 1. 메뉴 버튼 클릭 구현
      2. 네트워크 통신 구현
 */
class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SessionViewModel by activityViewModels()
    private lateinit var adapter: SessionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.let {
            it.lifecycleOwner = this
            it.viewModel = viewModel
            it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
    }

    private fun initializeView() {
        adapter = SessionAdapter(
            sessionClickListener = {
                viewModel.setSelectedSession(it)
                replaceTransaction<SessionInfoFragment>(R.id.fragment_container_view)
            },
            upButtonClickListener = {
                binding.conferenceRecyclerView.smoothScrollToPosition(0)
            }
        )
        binding.conferenceRecyclerView.adapter = adapter
        viewModel.updateSessionData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}