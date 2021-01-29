package com.survivalcoding.ifkakao.ui.view.home

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentMainBinding
import com.survivalcoding.ifkakao.extension.LinearVerticalLayout
import com.survivalcoding.ifkakao.extension.navigate
import com.survivalcoding.ifkakao.ui.adapter.SessionAdapter
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.viewmodel.MainViewModel
import com.survivalcoding.ifkakao.util.SESSION_ITEM
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_main

    override val viewModel: MainViewModel by viewModel()

    override fun initStartView() {
        setToolbar()
        eventProcess()
        setRecyclerView()
        binding.progressMain.visibility = VISIBLE
    }

    override fun getViewModelData() {
        viewModel.getConferenceData()
    }

    override fun startObserveData() {
        observeConferenceSessionData()
    }

    private fun eventProcess() {
        binding.btnAllSessionMain.setOnClickListener {
            navigate(R.id.fragment_session)
        }
    }

    /* observe data */
    private fun observeConferenceSessionData() {
        viewModel.conferenceData.observe(this) {
            val adapter = binding.rvVideoMain.adapter as SessionAdapter
            adapter.setList(it)
            binding.progressMain.visibility = GONE
        }
    }

    /* set recycler view */
    private fun setRecyclerView() {
        binding.rvVideoMain.apply {
            layoutManager = LinearVerticalLayout(context)
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            adapter = SessionAdapter().apply {
                this.setSessionClickListener {
                    navigate(R.id.fragment_session_detail, bundleOf(SESSION_ITEM to it))
                }
            }
        }
    }

    /* set toolbar */
    private fun setToolbar() {
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(binding.include.toolbarMain)
        setHasOptionsMenu(true)

        binding.include.tvTitleMain.setOnClickListener {
            navigate(R.id.fragment_main)
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
                navigate(R.id.fragment_session_event)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}