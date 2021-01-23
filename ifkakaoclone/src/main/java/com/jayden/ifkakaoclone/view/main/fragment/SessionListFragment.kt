package com.jayden.ifkakaoclone.view.main.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import com.jayden.ifkakaoclone.R
import com.jayden.ifkakaoclone.data.viewmodel.SessionViewModel
import com.jayden.ifkakaoclone.databinding.FragmentSessionListBinding
import com.jayden.ifkakaoclone.extensions.replaceTransaction
import com.jayden.ifkakaoclone.view.main.adapter.SessionListAdapter

class SessionListFragment : Fragment() {
    private var _binding: FragmentSessionListBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        SessionListAdapter(
            showSessionDetail = {
                activityViewModel.setSelectedItem(it)
                replaceTransaction<SessionDetailFragment>(R.id.fragment_container_view)
            },
            openWebUrl = { openIfKakao2019() },
            scrollToTop = { smoothScrollToTop() },
        )
    }

    private val activityViewModel: SessionViewModel by activityViewModels()

    private val smoothScroller by lazy {
        object : LinearSmoothScroller(requireContext()) {
            override fun getVerticalSnapPreference(): Int = SNAP_TO_START
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSessionListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            recyclerView.adapter = adapter
            recyclerView.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    LinearLayoutManager.VERTICAL
                )
            )
        }

        activityViewModel.sessions.observe(viewLifecycleOwner) {
            adapter.addHeaderAndSetItems(it)
            adapter.notifyDataSetChanged()
        }
    }

    private fun smoothScrollToTop() {
        smoothScroller.targetPosition = 0
        binding.recyclerView.layoutManager?.startSmoothScroll(smoothScroller)
    }

    private fun openIfKakao2019() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://if.kakao.com/2019"))
        startActivity(intent)
    }
}