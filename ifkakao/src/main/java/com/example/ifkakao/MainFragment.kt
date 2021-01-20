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

/*
TODO: 1. 메뉴 버튼 클릭 구현
      2. 네트워크 통신 구현
      3. 상세 프레그먼트 구현
      4. 세션 누르면 상세 프래그먼트로 이동하도록 구현
      5. 스크롤 위로가기 버튼 구현
 */
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