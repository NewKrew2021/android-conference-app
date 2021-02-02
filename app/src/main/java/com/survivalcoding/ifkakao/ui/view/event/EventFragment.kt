package com.survivalcoding.ifkakao.ui.view.event

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentEventBinding
import com.survivalcoding.ifkakao.extension.navigate
import com.survivalcoding.ifkakao.extension.setToolbar
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.viewmodel.EventViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventFragment : BaseFragment<FragmentEventBinding, EventViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_event

    override val viewModel: EventViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar()
    }

    private fun setToolbar() {
        binding.include.toolbarMain.setBackgroundColor(Color.BLUE)
        setToolbar(binding.include.toolbarMain, binding.include.tvTitleMain)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_main -> {
                navigate(R.id.fragment_session_event)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}