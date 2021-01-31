package com.jayden.ifkakaoclone.view.main.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jayden.ifkakaoclone.R
import com.jayden.ifkakaoclone.databinding.FragmentHighlightBinding
import com.jayden.ifkakaoclone.extensions.navigateSingleTop
import com.jayden.ifkakaoclone.view.main.adapter.SessionListAdapter
import com.jayden.ifkakaoclone.view.main.model.Session
import com.jayden.ifkakaoclone.viewmodel.SessionViewModel

class HighlightFragment : Fragment() {
    private var _binding: FragmentHighlightBinding? = null
    private val binding
        get() = _binding!!

    private val adapter by lazy {
        SessionListAdapter { selectSessionEvent(it) }
    }

    private val activityViewModel: SessionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHighlightBinding.inflate(inflater, container, false)
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

            btnShowAllSessions.setOnClickListener { findNavController().navigateSingleTop(R.id.sessionListFragment) }

            layoutFooter.imageScrollTop.setOnClickListener {
                smoothScrollToAppbar()
            }

            layoutFooter.textIfkakao2019.setOnClickListener {
                openIfKakao2019()
            }
        }

        activityViewModel.sessions.observe(viewLifecycleOwner) {
            updateHighlightSessions(it)
        }

        activityViewModel.fetchContents()
    }

    private fun updateHighlightSessions(sessions: List<Session>) {
        adapter.submitList(sessions.filter { it.spotlightYn == "Y" })
    }

    private fun selectSessionEvent(session: Session) {
        val actionWithArgs =
            HighlightFragmentDirections.actionHighlightFragmentToSessionDetailFragment(session)
        findNavController().navigate(actionWithArgs)
    }

    private fun smoothScrollToAppbar() {
        with(binding) {
            nestedScrollView.smoothScrollTo(0, 0)
        }
    }

    private fun openIfKakao2019() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://if.kakao.com/2019"))
        startActivity(intent)
    }
}