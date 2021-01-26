package com.example.ifkakao.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.ifkakao.R
import com.example.ifkakao.adapter.SessionAdapter
import com.example.ifkakao.databinding.FragmentHighlighBinding
import com.example.ifkakao.util.replaceTransaction
import com.example.ifkakao.viewmodel.SessionViewModel

/*
TODO: 1. 데이터 제대로 필터링 안되는 것 처리
      2. 가로, 세로에 따라 레이아웃 구성
      3. 데이터 바인딩 적용
*/
class HighlightFragment : Fragment() {
    private var _binding: FragmentHighlighBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: SessionAdapter
    private val viewModel: SessionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHighlighBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        observeData()
    }

    private fun observeData() {
        viewModel.highlightSession.observe(viewLifecycleOwner) {
            adapter.submitList(it.toList())
        }
    }

    private fun initializeView() {
        Glide.with(binding.handImage).load(R.drawable.shake_hand).into(binding.handImage)
        adapter = SessionAdapter(
            sessionClickListener = {
                viewModel.setSelectedSession(it)
                replaceTransaction<SessionInfoFragment>(R.id.fragment_container_view)
            },
            upButtonClickListener = {}
        )
        binding.highlightListRecycler.adapter = adapter
        binding.allSessionButton.setOnClickListener {
            replaceTransaction<MainFragment>(R.id.fragment_container_view)
        }
        viewModel.updateHighlightSessionList()
    }
}