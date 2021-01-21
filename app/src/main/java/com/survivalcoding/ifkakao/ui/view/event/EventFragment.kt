package com.survivalcoding.ifkakao.ui.view.event

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentEventBinding
import com.survivalcoding.ifkakao.extension.replaceFragment
import com.survivalcoding.ifkakao.extension.setToolbar
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.view.menu.SessionEventMenuFragment
import com.survivalcoding.ifkakao.ui.viewmodel.EventViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventFragment : BaseFragment<FragmentEventBinding, EventViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_event

    override val viewModel: EventViewModel by viewModel()

    override fun initStartView() {
        setToolbar(binding.include.toolbarMain, binding.include.tvTitleMain)
    }

    override fun getViewModelData() {
        //
    }

    override fun startObserveData() {
        //

    }

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