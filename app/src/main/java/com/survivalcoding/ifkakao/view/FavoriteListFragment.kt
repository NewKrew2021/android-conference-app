package com.survivalcoding.ifkakao.view

import android.os.Bundle
import android.view.*
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.DividerItemDecoration
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.adapter.ConferenceListAdapter
import com.survivalcoding.ifkakao.databinding.FragmentFavoriteListBinding
import com.survivalcoding.ifkakao.model.conferenceData.Data
import com.survivalcoding.ifkakao.viewmodel.ConferenceViewModel
import com.survivalcoding.ifkakao.viewmodel.FavoriteViewModel


class FavoriteListFragment : Fragment() {
    private var _bindng: FragmentFavoriteListBinding? = null
    lateinit var favoriteListAdapter: ConferenceListAdapter
    val listViewModel: ConferenceViewModel by activityViewModels()
    val favoriteViewModel: FavoriteViewModel by activityViewModels()

    private val binding get() = _bindng!!
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        _bindng = FragmentFavoriteListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindng = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favoriteListAdapter = ConferenceListAdapter(
                showDetail = {
                    listViewModel.setSelectItem(it)
                    parentFragmentManager.popBackStack(
                            "DetailFragment",
                            FragmentManager.POP_BACK_STACK_INCLUSIVE
                    )
                    parentFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace(R.id.fragmentContainerView, DetailFragment())
                        addToBackStack("DetailFragment")
                    }
                }
        )

        val dividerItemDecoration = DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
        )
        ResourcesCompat.getDrawable(requireContext().resources, R.drawable.custom_divider, null)
                ?.let {
                    dividerItemDecoration.setDrawable(it)
                }
        binding.apply {
            favoriteListView.addItemDecoration(
                    dividerItemDecoration
            )
            favoriteListView.adapter = favoriteListAdapter
        }

        listViewModel.loadData()
        listViewModel.list.observe(viewLifecycleOwner) { list ->
            favoriteViewModel.favoriteAllList.observe(viewLifecycleOwner) { favoriteList ->
                val favoriteData = mutableListOf<Data>()
                list.forEach {
                    favoriteList.forEach { it2 ->
                        if (it.idx == it2.id) {
                            favoriteData.add(it)
                        }
                    }
                }
                updateList(favoriteData)
            }
        }
    }

    private fun updateList(list: List<Data>) {
        favoriteListAdapter.submitList(list)
        binding.favoriteListView.scrollToPosition(0)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear();
        inflater.inflate(R.menu.actionbar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigationButton -> {
                parentFragmentManager.popBackStack(
                        "NavigationFragment",
                        FragmentManager.POP_BACK_STACK_INCLUSIVE
                )
                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.fragmentContainerView, NavigationFragment())
                    addToBackStack("NavigationFragment")
                }
            }

        }
        return super.onOptionsItemSelected(item)
    }
}