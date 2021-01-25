package com.survivalcoding.ifkakao.ui.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.adapter.ConferenceAdapter
import com.survivalcoding.ifkakao.databinding.FragmentMainBinding
import com.survivalcoding.ifkakao.extension.openDetailFragment
import com.survivalcoding.ifkakao.viewmodel.ConferenceViewModel

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ConferenceAdapter
    private val viewModel: ConferenceViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

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
        setUpObserver()
        setHasOptionsMenu(true)

        (activity as MainActivity).setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater)
        menuInflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_button -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initView() {

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

    private fun setUpObserver() {
        viewModel.sessions.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}