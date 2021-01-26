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
import com.jayden.ifkakaoclone.R
import com.jayden.ifkakaoclone.data.viewmodel.SessionViewModel
import com.jayden.ifkakaoclone.databinding.FragmentSessionListBinding
import com.jayden.ifkakaoclone.extensions.replaceTransaction
import com.jayden.ifkakaoclone.view.main.adapter.SessionListAdapter
import com.jayden.ifkakaoclone.view.main.model.Session

class SessionListFragment : Fragment() {
    private var _binding: FragmentSessionListBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        SessionListAdapter(
            selectSessionEvent = { selectSessionEvent(it) }
        )
    }

    private val activityViewModel: SessionViewModel by activityViewModels()

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

            layoutFooter.imageScrollTop.setOnClickListener {
                smoothScrollToAppbar()
            }

            layoutFooter.textIfkakao2019.setOnClickListener {
                openIfKakao2019()
            }
        }

        activityViewModel.sessions.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun selectSessionEvent(session: Session) {
        activityViewModel.setSelectedItem(session)
        replaceTransaction<SessionDetailFragment>(R.id.fragment_container_view)
    }

    private fun smoothScrollToAppbar() {
        with(binding) {
            nestedScrollView.smoothScrollTo(0, 0)
            appbar.setExpanded(true)
        }
    }

    private fun openIfKakao2019() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://if.kakao.com/2019"))
        startActivity(intent)
    }
}