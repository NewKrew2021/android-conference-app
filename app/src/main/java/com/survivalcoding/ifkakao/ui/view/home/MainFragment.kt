package com.survivalcoding.ifkakao.ui.view.home

import android.content.Context
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ScrollView
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentMainBinding
import com.survivalcoding.ifkakao.extension.replaceFragment
import com.survivalcoding.ifkakao.extension.setToolbar
import com.survivalcoding.ifkakao.ui.adapter.SessionAdapter
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.view.menu.SessionEventMenuFragment
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
    }

    /* observe data */
    private fun observeConferenceSessionData() {
        viewModel.conferenceData.observe(this) {
            val adapter = binding.rvVideoMain.adapter as SessionAdapter
            adapter.setList(it)
        }
    }

    /* set view */
    private fun setRecyclerView() {
        val layout = { context: Context ->
            LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        }
        binding.rvVideoMain.apply {
            layoutManager = layout(context)
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
            R.id.toolbar_item_main -> {
                replaceFragment<SessionEventMenuFragment>(R.id.fragment_container_view)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}