package com.survivalcoding.ifkakao.ui.view.session

import android.net.Uri
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentSessionBinding
import com.survivalcoding.ifkakao.extension.replaceFragment
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.view.MainActivity
import com.survivalcoding.ifkakao.ui.view.home.MainFragment
import com.survivalcoding.ifkakao.ui.view.menu.SessionEventMenuFragment
import com.survivalcoding.ifkakao.ui.viewmodel.SessionViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SessionFragment : BaseFragment<FragmentSessionBinding, SessionViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_session

    override val viewModel: SessionViewModel by viewModel()

    override fun initStartView() {
        setVideoView()
        setCustomToolbar()
        setToolbar()
    }

    override fun getViewModelData() {
        //
    }

    override fun startObserveData() {
        //
    }


    // set toolbar
    private fun setToolbar() {
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(binding.toolbarSession)
        setHasOptionsMenu(true)
    }

    private fun setCustomToolbar() {
        binding.include.tvTitleMain.setOnClickListener {
            replaceFragment<MainFragment>(R.id.fragment_container_view)
        }
        binding.include.ivTitleMain.setOnClickListener {
            replaceFragment<SessionEventMenuFragment>(R.id.fragment_container_view)
        }
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
        inflater.inflate(R.menu.toolbar_menu_session,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            else -> super.onOptionsItemSelected(item)
        }
    }

}