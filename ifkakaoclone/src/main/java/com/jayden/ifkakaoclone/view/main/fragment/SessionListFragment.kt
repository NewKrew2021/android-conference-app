package com.jayden.ifkakaoclone.view.main.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jayden.ifkakaoclone.R
import com.jayden.ifkakaoclone.databinding.FragmentSessionListBinding
import com.jayden.ifkakaoclone.view.main.adapter.SessionListAdapter
import com.jayden.ifkakaoclone.view.main.model.Session
import com.jayden.ifkakaoclone.viewmodel.SessionViewModel

class SessionListFragment : Fragment() {
    private var _binding: FragmentSessionListBinding? = null
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
        _binding = FragmentSessionListBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@SessionListFragment
            viewModel = activityViewModel
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as AppCompatActivity).supportActionBar?.show()

        with(binding) {
            recyclerView.adapter = adapter
            recyclerView.addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    LinearLayoutManager.VERTICAL
                )
            )

            layoutMyList.setOnClickListener {
                activityViewModel.toggleFilterWithFavorite()
            }

            btnFilter.setOnClickListener {
                findNavController().navigate(R.id.action_sessionListFragment_to_filterDetailFragment)
            }

            layoutFooter.imageScrollTop.setOnClickListener {
                smoothScrollToAppbar()
            }

            layoutFooter.textIfkakao2019.setOnClickListener {
                openIfKakao2019()
            }
        }

        activityViewModel.sessions.observe(viewLifecycleOwner) {
            updateSessionsWithFilters(it)
        }

        activityViewModel.shouldFilterWithFavorite.observe(viewLifecycleOwner) {
            updateSessionsWithFilters(activityViewModel.sessions.value ?: listOf())
        }

        activityViewModel.favorites.observe(viewLifecycleOwner) { } // DB에 접근하기 전까진 favorites 가 null 이여서

        activityViewModel.fetchContents()
    }

    private fun selectSessionEvent(session: Session) {
        val actionWithArgs =
            SessionListFragmentDirections.actionSessionListFragmentToSessionDetailFragment(session)
        findNavController().navigate(actionWithArgs)
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

    private fun updateSessionsWithFilters(sessions: List<Session>) {
        val shouldFilterWithFavorite = activityViewModel.shouldFilterWithFavorite.value ?: false

        val filtered = if (shouldFilterWithFavorite) filteredByFavorite(sessions) else sessions

        activityViewModel.appliedFilters.value?.let { filters ->
            if (filters.isNotEmpty()) {
                adapter.submitList(filtered.filter { filters.contains(it.field) })
            } else {
                adapter.submitList(filtered)
            }
        } ?: adapter.submitList(filtered)
    }

    private fun filteredByFavorite(sessions: List<Session>): List<Session> {
        val favoriteIndexes = activityViewModel.favorites.value?.filter { it.isFavorite }?.map { it.uid } ?: listOf()

        return sessions.filter { favoriteIndexes.contains(it.idx) }
    }
}