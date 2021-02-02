package com.survivalcoding.ifkakao.ui.view.session

import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.data.model.response.ConferenceSessionResponse
import com.survivalcoding.ifkakao.databinding.FragmentSessionBinding
import com.survivalcoding.ifkakao.extension.initToLinearLayout
import com.survivalcoding.ifkakao.extension.navigate
import com.survivalcoding.ifkakao.extension.stop
import com.survivalcoding.ifkakao.ui.adapter.SessionAdapter
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.view.filter.SessionFilterFragment
import com.survivalcoding.ifkakao.ui.viewmodel.SessionViewModel
import com.survivalcoding.ifkakao.util.EMPTY_STRING
import com.survivalcoding.ifkakao.util.SESSION_ITEM
import com.survivalcoding.ifkakao.util.SESSION_MAIN_VIDEO_URL
import org.koin.androidx.viewmodel.ext.android.viewModel

class SessionFragment : BaseFragment<FragmentSessionBinding, SessionViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_session

    override val viewModel: SessionViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getFilteredDataFromBundle()
        setView()
        subscribeUI()
    }

    private fun getFilteredDataFromBundle() {
        arguments?.let {
            val filter = it.getString(SessionFilterFragment.KEY_OF_FILTER_BUNDLE)
            if (filter != null) {
                viewModel.getConferenceData(filter)
            } else {
                viewModel.getConferenceData(EMPTY_STRING)
            }
        } ?: viewModel.getConferenceData(EMPTY_STRING)
    }

    private fun setView() {
        setRecyclerView()
        setToolbar()
        setVideoView()
        viewModel.setLikeCheck(false)
    }

    private fun setRecyclerView() {
        binding.rvVideoSession.initToLinearLayout(
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
        activity.setSupportActionBar(binding.toolbarSession)
        setHasOptionsMenu(true)

        binding.include.toolbarMain.run {
            inflateMenu(R.menu.toolbar_menu_main)
            setOnMenuItemClickListener {
                if (it.itemId == R.id.action_main) navigate(R.id.fragment_session_event)
                true
            }
        }

        binding.include.tvTitleMain.setOnClickListener {
            navigate(R.id.fragment_main)
        }
    }

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

    private fun subscribeUI() = with(viewModel) {
        conferenceData.observe { setSessionAdapterData(it) }
    }

    private fun setSessionAdapterData(list: List<ConferenceSessionResponse>) {
        val adapter = binding.rvVideoSession.adapter as SessionAdapter
        adapter.setList(list)
        binding.progressSession.stop()
    }

    private fun observeLikeCheck(likeItem: MenuItem, unlikeItem: MenuItem) {
        viewModel.likeCheck.observe(this) {
            if (it) {
                likeItem.isVisible = true
                unlikeItem.isVisible = false
                viewModel.getFavoriteConferenceData()
            } else {
                likeItem.isVisible = false
                unlikeItem.isVisible = true
                getFilteredDataFromBundle()
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
                navigate(R.id.fragment_session_filter)
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
