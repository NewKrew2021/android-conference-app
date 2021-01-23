package com.survivalcoding.ifkakao.ifkakao.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.survivalcoding.ifkakao.databinding.FragmentIfKakaoBinding
import com.survivalcoding.ifkakao.ifkakao.model.Data
import com.survivalcoding.ifkakao.ifkakao.view.main.adapter.IfKakaoAdapter
import com.survivalcoding.ifkakao.ifkakao.viewmodel.IfKakaoViewModel

class IfKakaoFragment() : Fragment() {
    private var _binding: FragmentIfKakaoBinding? = null
    private val binding get() = _binding!!

    val adapter = IfKakaoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIfKakaoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = "If Kakao 2020"
        binding.apply {
            ifKakaoListView.adapter = adapter
        }

        // ViewModel 가져오기.
        val model: IfKakaoViewModel by viewModels()
        // LiveData가 수정될 때 실행할 메소드
        model.ifKakaoSessionList.observe(viewLifecycleOwner, Observer {
            updateUi(it.data)
        })

        model.loadIfKakaoItem()
    }

    fun updateUi(list: List<Data>) {
        adapter.submitList(list)
    }
}