package com.survivalcoding.ifkakao.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentMainBinding
import com.survivalcoding.ifkakao.util.extensions.navigateTo
import com.survivalcoding.ifkakao.view.MainViewModel
import com.survivalcoding.ifkakao.view.detail.DetailFragment
import com.survivalcoding.ifkakao.view.main.adapter.ConferenceRecyclerAdapter

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by activityViewModels()

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val conferenceAdapter by lazy {
        ConferenceRecyclerAdapter {
            viewModel.selectItem(it)
            navigateTo<DetailFragment>(R.id.fragment_container_view)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.recyclerView) {
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(), LinearLayoutManager.VERTICAL
                ).apply {
                    ResourcesCompat.getDrawable(
                        requireContext().resources, R.drawable.item_divider, null
                    )?.let {
                        setDrawable(it)
                    }
                }
            )
            adapter = conferenceAdapter
        }

        conferenceAdapter.submitList(viewModel.getContents())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}