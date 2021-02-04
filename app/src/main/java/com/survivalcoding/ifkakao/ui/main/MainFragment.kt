package com.survivalcoding.ifkakao.ui.main

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentMainBinding
import com.survivalcoding.ifkakao.extension.openDetailFragment
import com.survivalcoding.ifkakao.extension.openFragmentWith
import com.survivalcoding.ifkakao.ui.filter.FilteringFragment
import com.survivalcoding.ifkakao.ui.info.InfoFragment
import com.survivalcoding.ifkakao.ui.main.adapter.ConferenceAdapter
import com.survivalcoding.ifkakao.viewmodel.ConferenceViewModel

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ConferenceAdapter

    private val viewModel: ConferenceViewModel by lazy {
        (requireActivity() as MainActivity).confViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        adapter = ConferenceAdapter(
            itemClickListener = {
                openDetailFragment(it)
            }
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        setUpObservers()
        setHasOptionsMenu(true)

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater)
        menuInflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_button -> {
                openFragmentWith<InfoFragment>()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initView() {

        binding.apply {
            viewModel = this@MainFragment.viewModel
            lifecycleOwner = this@MainFragment
        }

        binding.toolbar.apply {
            title = "if(kakao)2020"
        }

        binding.recyclerview.apply {
            adapter = this@MainFragment.adapter
            addItemDecoration(
                DividerItemDecoration(
                    requireActivity(),
                    DividerItemDecoration.VERTICAL
                )
            )
        }

        loadConferencesFromServer()
    }

    private fun loadConferencesFromServer() {
        viewModel.requestConfData()
    }

    private fun setUpObservers() {
        viewModel.sessionsForShow.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        viewModel.onFilteringButtonClicked.observe(viewLifecycleOwner) {
            openFragmentWith<FilteringFragment>()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}