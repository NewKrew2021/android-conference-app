package com.survivalcoding.ifkakao.ifkakao.view.sorted

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentPresentationBinding
import com.survivalcoding.ifkakao.databinding.FragmentSortedListBinding
import com.survivalcoding.ifkakao.ifkakao.model.Data
import com.survivalcoding.ifkakao.ifkakao.model.IfKakaoResponse
import com.survivalcoding.ifkakao.ifkakao.view.main.adapter.IfKakaoAdapter
import com.survivalcoding.ifkakao.ifkakao.view.presentation.PresentationFragment
import com.survivalcoding.ifkakao.ifkakao.viewmodel.IfKakaoViewModel

class SortedListFragment() : Fragment() {
    private var _binding: FragmentSortedListBinding? = null
    private val binding get() = _binding!!

    private val model: IfKakaoViewModel by activityViewModels()
    private val adapter: IfKakaoAdapter = IfKakaoAdapter({
        val action = SortedListFragmentDirections.actionSortedListFragmentToPresentationFragment(it)
        findNavController().navigate(action)
    }, {
        Toast.makeText(context, "이미 ${it}입니다.", Toast.LENGTH_SHORT).show()
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSortedListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: SortedListFragmentArgs by navArgs()
        val fieldText = args.fieldName
        binding.itemText = fieldText
        binding.sortedItemList.adapter = adapter    // if kakao list와 같은 어댑터라서 동일하게 사용

        val sessionList = model.ifKakaoSessionList.value

        val sortedList = sessionList?.data?.filter { it.field == fieldText }
        adapter.submitList(sortedList)
    }
}