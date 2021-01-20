package com.survivalcoding.ifkakao.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.adapter.ConferenceListAdapter
import com.survivalcoding.ifkakao.databinding.FragmentConferenceListBinding
import com.survivalcoding.ifkakao.model.conferenceData.Data
import com.survivalcoding.ifkakao.viewmodel.ConferenceViewModel


class ConferenceListFragment() : Fragment() {
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
        val dividerItemDecoration = DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
        )
        ResourcesCompat.getDrawable(requireContext().resources, R.drawable.custom_divider, null)?.let {
            dividerItemDecoration.setDrawable(it)
        }

        binding.apply {
            conferenceListView.addItemDecoration(
                    dividerItemDecoration
            )
            conferenceListView.adapter = conferenceListAdapter
        }

        val viewModel: ConferenceViewModel by viewModels()
        viewModel.list.observe(viewLifecycleOwner, Observer<List<Data>>{
            updateList(it)
        })
        viewModel.loadData()

    }

    private fun updateList(list : List<Data>) {
        conferenceListAdapter.submitList(list)
    }

}