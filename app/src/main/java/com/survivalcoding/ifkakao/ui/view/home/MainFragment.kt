package com.survivalcoding.ifkakao.ui.view.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.data.model.response.ConferenceSessionResponse
import com.survivalcoding.ifkakao.databinding.FragmentMainBinding
import com.survivalcoding.ifkakao.extension.initToLinearLayout
import com.survivalcoding.ifkakao.extension.navigate
import com.survivalcoding.ifkakao.extension.stop
import com.survivalcoding.ifkakao.ui.adapter.SessionAdapter
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.viewmodel.MainViewModel
import com.survivalcoding.ifkakao.util.SESSION_ITEM
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_main

    override val viewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this
        getViewModelData()
        setView()
        subscribeUI()
    }

    private fun getViewModelData() {
        viewModel.getConferenceData()
    }

    private fun setView() {
        setToolbar()
        setRecyclerView()
    }

    private fun setRecyclerView() {
        binding.rvVideoMain.initToLinearLayout(
            layoutType = LinearLayoutManager.VERTICAL,
            isDivider = true,
            adapter = SessionAdapter().apply {
                this.setSessionClickListener {
                    navigate(R.id.fragment_session_detail, bundleOf(SESSION_ITEM to it))
                }
            }
        )
    }

    private fun setToolbar() {
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(binding.include.toolbarMain)
        setHasOptionsMenu(true)

        binding.include.tvTitleMain.setOnClickListener {
            navigate(R.id.fragment_main)
        }
    }

    private fun subscribeUI() = with(viewModel) {
        conferenceData.observe { setSessionAdapterData(it) }
    }

    private fun setSessionAdapterData(list: List<ConferenceSessionResponse>) {
        val adapter = binding.rvVideoMain.adapter as SessionAdapter
        adapter.setList(list)
        binding.progressMain.stop()
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