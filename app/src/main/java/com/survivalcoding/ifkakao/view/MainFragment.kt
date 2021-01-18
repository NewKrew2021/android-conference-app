package com.survivalcoding.ifkakao.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.adapter.ConferenceAdapter
import com.survivalcoding.ifkakao.databinding.FragmentMainBinding
import com.survivalcoding.ifkakao.viewmodel.ConferenceViewModel

class MainFragment(private val viewModel: ConferenceViewModel) : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ConferenceAdapter

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
        initializeView()
    }

    private fun initializeView() {
        adapter = ConferenceAdapter(viewModel, itemClickListener = {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                addToBackStack(null)
                val bundle = Bundle().apply {
                    putParcelable(CONFERENCE_INFO, it)
                }
                replace<ConferenceInfoFragment>(R.id.fragment_container_view, args = bundle)
            }
        }
        )

        binding.apply {
            conferenceRecyclerView.adapter = adapter
            // 구분선 추가
            conferenceRecyclerView.addItemDecoration(
                DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
            )
        }
    }

    companion object {
        const val CONFERENCE_INFO = "conference info"
    }
}