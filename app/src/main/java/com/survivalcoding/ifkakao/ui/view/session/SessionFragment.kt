package com.survivalcoding.ifkakao.ui.view.session

import android.net.Uri
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentSessionBinding
import com.survivalcoding.ifkakao.extension.LinearVerticalLayout
import com.survivalcoding.ifkakao.extension.replaceFragment
import com.survivalcoding.ifkakao.extension.replaceFragmentWithBundle
import com.survivalcoding.ifkakao.ui.adapter.SessionAdapter
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.view.filter.SessionFilterFragment
import com.survivalcoding.ifkakao.ui.view.home.MainFragment
import com.survivalcoding.ifkakao.ui.view.menu.SessionEventMenuFragment
import com.survivalcoding.ifkakao.ui.viewmodel.SessionViewModel
import com.survivalcoding.ifkakao.util.EMPTY_STRING
import com.survivalcoding.ifkakao.util.SESSION_ITEM
import com.survivalcoding.ifkakao.util.SESSION_MAIN_VIDEO_URL
import org.koin.androidx.viewmodel.ext.android.viewModel

class SessionFragment : BaseFragment<FragmentSessionBinding, SessionViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_session

    override val viewModel: SessionViewModel by viewModel()

    override fun initStartView() {
        setVideoView()
        setToolbar()
        setRecyclerView()
        viewModel.setLikeCheck(false)
    }

    override fun getViewModelData() {
        arguments?.let {
            val filter = it.getString("filter")
            if (filter != null) {
                viewModel.getConferenceData(filter)
            } else {
                viewModel.getConferenceData(EMPTY_STRING)
            }
        } ?: viewModel.getConferenceData(EMPTY_STRING)

    }

    override fun startObserveData() {
        observeConferenceSessionData()
    }

    // observe data
    private fun observeConferenceSessionData() {
        viewModel.conferenceData.observe(this) {
            val adapter = binding.rvVideoSession.adapter as SessionAdapter
            adapter.setList(it)
        }
    }

    private fun observeLikeCheck(likeItem: MenuItem, unlikeItem: MenuItem) {
        viewModel.likeCheck.observe(this) {
            if(it) {
                likeItem.isVisible = true
                unlikeItem.isVisible = false
                viewModel.getFavoriteConferenceData()
            } else {
                likeItem.isVisible = false
                unlikeItem.isVisible = true
                getViewModelData()
            }
        }
    }

    // set recycler view
    private fun setRecyclerView() {
        binding.rvVideoSession.apply {
            layoutManager = LinearVerticalLayout(context)
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            adapter = SessionAdapter().apply {
                this.setSessionClickListener {
                    replaceFragmentWithBundle(
                        R.id.fragment_container_view,
                        SessionDetailFragment::class,
                        bundleOf(SESSION_ITEM to it)
                    )
                }
            }
        }
    }

    // set toolbar
    private fun setToolbar() {
        val activity = activity as AppCompatActivity
        activity.setSupportActionBar(binding.toolbarSession)
        setHasOptionsMenu(true)

        binding.include.toolbarMain.run {
            inflateMenu(R.menu.toolbar_menu_main)
            setOnMenuItemClickListener {
                if (it.itemId == R.id.action_main) replaceFragment<SessionEventMenuFragment>(R.id.fragment_container_view)
                true
            }
        }

        binding.include.tvTitleMain.setOnClickListener {
            replaceFragment<MainFragment>(R.id.fragment_container_view)
        }
    }

    // set video view
    private fun setVideoView() {
        binding.videoViewSession.apply {
            setVideoURI(Uri.parse(SESSION_MAIN_VIDEO_URL))
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
        inflater.inflate(R.menu.toolbar_menu_session, menu)

        val likeItem = binding.toolbarSession.menu.findItem(R.id.action_like)
        val unlikeItem = binding.toolbarSession.menu.findItem(R.id.action_unlike)

        observeLikeCheck(likeItem, unlikeItem)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_filter -> {
                replaceFragment<SessionFilterFragment>(R.id.fragment_container_view)
                true
            }
            R.id.action_like -> {
                viewModel.setLikeCheck(false)
                true
            }
            R.id.action_unlike -> {
                viewModel.setLikeCheck(true)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}