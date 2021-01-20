package com.survivalcoding.ifkakao.ui.view.home

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ScrollView
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentMainBinding
import com.survivalcoding.ifkakao.extension.replaceFragment
import com.survivalcoding.ifkakao.extension.setToolbar
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
    }

    override fun getViewModelData() {
        viewModel.getConferenceData()
    }

    override fun startObserveData() {
        //
    }

    private fun eventProcess() {
        binding.ivUpScrollMain.setOnClickListener {
            binding.svMain.fullScroll(ScrollView.FOCUS_UP)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_menu, menu)
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