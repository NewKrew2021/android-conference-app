package com.survivalcoding.ifkakao.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import com.survivalcoding.ifkakao.adapter.ConferenceListAdapter
import com.survivalcoding.ifkakao.databinding.FragmentConferenceListBinding
import com.survivalcoding.ifkakao.repository.Repository


class ConferenceListFragment(private val repository: Repository) : Fragment() {
    private var _bindng: FragmentConferenceListBinding? = null
    lateinit var conferenceListAdapter: ConferenceListAdapter
    private val binding get() = _bindng!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _bindng = FragmentConferenceListBinding.inflate(inflater, container, false)
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
            conferenceListView.addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
            conferenceListView.adapter = conferenceListAdapter
        }
        updateList()
    }

    private fun updateList() {
        val list = repository.getRequests()
        conferenceListAdapter.submitList(list)
    }

}