package com.survivalcoding.ifkakao.ifkakao.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.survivalcoding.ifkakao.databinding.FragmentIfKakaoBinding
import com.survivalcoding.ifkakao.ifkakao.model.Data
import com.survivalcoding.ifkakao.ifkakao.view.main.adapter.IfKakaoAdapter
import com.survivalcoding.ifkakao.ifkakao.viewmodel.IfKakaoViewModel

class IfKakaoFragment(private val data: List<Data>) : Fragment() {
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
        adapter.submitList(data)

//        val model: IfKakaoViewModel by viewModels()
//        model.ifkakaoItem.observe(viewLifecycleOwner, Observer {
//            updateUi(it.data)
//        })
    }

    fun updateUi(list: List<Data>) {
        adapter.submitList(list)
    }
}