package com.survivalcoding.ifkakao.ui.view.session

import android.net.Uri
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentSessionBinding
import com.survivalcoding.ifkakao.extension.replaceFragment
import com.survivalcoding.ifkakao.extension.setToolbar
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.view.MainActivity
import com.survivalcoding.ifkakao.ui.view.menu.SessionEventMenuFragment
import com.survivalcoding.ifkakao.ui.viewmodel.SessionViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SessionFragment : BaseFragment<FragmentSessionBinding, SessionViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_session

    override val viewModel: SessionViewModel by viewModel()

    override fun initStartView() {
        setToolbar(binding.include.toolbarMain, binding.include.tvTitleMain)
        setVideoView()
    }

    override fun getViewModelData() {
        //
    }

    override fun startObserveData() {
        //
    }


    // set video view
    private fun setVideoView() {
        val activity = requireActivity() as MainActivity
        binding.videoViewSession.apply {
            setVideoURI(Uri.parse("android.resource://${activity.packageName}/raw/sample"))
            setOnPreparedListener {
                it.start()
            }
            setOnCompletionListener {
                it.start()
            }
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