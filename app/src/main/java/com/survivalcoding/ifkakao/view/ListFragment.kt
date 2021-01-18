package com.survivalcoding.ifkakao.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.survivalcoding.ifkakao.adapter.ConferenceListAdapter
import com.survivalcoding.ifkakao.databinding.FragmentListBinding
import com.survivalcoding.ifkakao.model.ConferenceItem
import com.survivalcoding.ifkakao.repository.Repository


class ListFragment(private val repository: Repository) : Fragment() {
    private var _bindng: FragmentListBinding? = null
    lateinit var conferenceListAdapter: ConferenceListAdapter
    private val binding get() = _bindng!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindng = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindng = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        conferenceListAdapter = ConferenceListAdapter()
        binding.apply {
            conferenceListView.adapter = conferenceListAdapter
        }
//        updateList()
        val list = mutableListOf<ConferenceItem>(ConferenceItem("123","123","123","123","123",false))
        conferenceListAdapter.submitList(list.toMutableList())
    }

    private fun updateList() {
        val list = repository.getConferenceList()
        conferenceListAdapter.submitList(list.toMutableList())
    }

}