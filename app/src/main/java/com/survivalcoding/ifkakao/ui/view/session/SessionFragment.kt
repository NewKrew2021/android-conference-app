package com.survivalcoding.ifkakao.ui.view.session

import android.net.Uri
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentSessionBinding
import com.survivalcoding.ifkakao.extension.LinearVerticalLayout
import com.survivalcoding.ifkakao.extension.replaceFragment
import com.survivalcoding.ifkakao.ui.adapter.SessionAdapter
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.view.home.MainFragment
import com.survivalcoding.ifkakao.ui.view.menu.SessionEventMenuFragment
import com.survivalcoding.ifkakao.ui.viewmodel.SessionViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SessionFragment : BaseFragment<FragmentSessionBinding, SessionViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_session

    override val viewModel: SessionViewModel by viewModel()

    private var likeCheck: Boolean = false

    private val likeItem by lazy {
        binding.toolbarSession.menu.findItem(R.id.action_like)
    }
    private val unlikeItem by lazy {
        binding.toolbarSession.menu.findItem(R.id.action_unlike)
    }

    override fun initStartView() {
        setVideoView()
        setToolbar()
        setRecyclerView()
    }

    override fun getViewModelData() {
        viewModel.getConferenceData()
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

    // set recycler view
    private fun setRecyclerView() {
        binding.rvVideoSession.apply {
            layoutManager = LinearVerticalLayout(context)
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            adapter = SessionAdapter()
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
        likeItem.isVisible = false
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_filter -> {
                Toast.makeText(requireContext(), "필터 클릭", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_like -> {
                likeItem.isVisible = false
                unlikeItem.isVisible = true
                likeCheck = false
                Toast.makeText(requireContext(), "좋아요 설정 해제", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_unlike -> {
                unlikeItem.isVisible = false
                likeItem.isVisible = true
                likeCheck = true
                Toast.makeText(requireContext(), "좋아요 설정", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        const val SESSION_MAIN_VIDEO_URL =
            "android.resource://com.survivalcoding.ifkakao/raw/sample"
    }

}