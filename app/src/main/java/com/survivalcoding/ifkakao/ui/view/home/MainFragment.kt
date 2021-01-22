package com.survivalcoding.ifkakao.ui.view.home

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ScrollView
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentMainBinding
import com.survivalcoding.ifkakao.extension.LinearVerticalLayout
import com.survivalcoding.ifkakao.extension.replaceFragment
import com.survivalcoding.ifkakao.extension.setToolbar
import com.survivalcoding.ifkakao.ui.adapter.SessionAdapter
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.view.menu.SessionEventMenuFragment
import com.survivalcoding.ifkakao.ui.view.session.SessionFragment
import com.survivalcoding.ifkakao.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_main

    override val viewModel: MainViewModel by viewModel()

    override fun initStartView() {
        setToolbar(binding.include.toolbarMain, binding.include.tvTitleMain)
        eventProcess()
        setRecyclerView()
    }

    override fun getViewModelData() {
        viewModel.getConferenceData()
    }

    override fun startObserveData() {
        observeConferenceSessionData()
    }

    private fun eventProcess() {
        binding.ivUpScrollMain.setOnClickListener {
            binding.svMain.fullScroll(ScrollView.FOCUS_UP)
        }

        binding.btnAllSessionMain.setOnClickListener {
            replaceFragment<SessionFragment>(R.id.fragment_container_view)
        }
    }

    /* observe data */
    private fun observeConferenceSessionData() {
        viewModel.conferenceData.observe(this) {
            val adapter = binding.rvVideoMain.adapter as SessionAdapter
            adapter.setList(it)
        }
    }

    /* set recycler view */
    private fun setRecyclerView() {
        binding.rvVideoMain.apply {
            layoutManager = LinearVerticalLayout(context)
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            adapter = SessionAdapter()
        }
    }

    /* set menu */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_main -> {
                replaceFragment<SessionEventMenuFragment>(R.id.fragment_container_view)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}