package com.survivalcoding.ifkakao.ui.view.session

import android.content.Intent
import android.net.Uri
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.data.model.entity.Favorite
import com.survivalcoding.ifkakao.databinding.FragmentSessionDetailBinding
import com.survivalcoding.ifkakao.extension.LinearVerticalLayout
import com.survivalcoding.ifkakao.extension.navigate
import com.survivalcoding.ifkakao.extension.setToolbar
import com.survivalcoding.ifkakao.ui.adapter.SpeakerAdapter
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.viewmodel.SessionDetailViewModel
import com.survivalcoding.ifkakao.util.SESSION_ITEM
import org.koin.androidx.viewmodel.ext.android.viewModel

class SessionDetailFragment : BaseFragment<FragmentSessionDetailBinding, SessionDetailViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_session_detail

    override val viewModel: SessionDetailViewModel by viewModel()

    override fun initStartView() {
        setToolbar(binding.include.toolbarMain, binding.include.tvTitleMain)
        arguments?.let {
            viewModel.setConferenceSessionData(it.getParcelable(SESSION_ITEM))
        }
        setImageView()
        setRecyclerView()
        eventProcess()
        binding.progressSessionDetail.visibility = View.VISIBLE
    }

    override fun getViewModelData() {
        viewModel.getFavoriteSessionData()
    }

    override fun startObserveData() {
        observeSessionDetailData()
        observeFavoriteData()
    }

    private fun observeSessionDetailData() {
        viewModel.sessionData.observe(this) {
            binding.run {
                tvFiledSessionDetail.text = it.field
                tvTitleSessionDetail.text = it.parseString(it.title)
                tvContentsSessionDetail.text = it.parseString(it.content)
                tvHashtagSessionDetail.text = it.contentTag
            }

            val adapter = binding.rvSpeakerSessionDetail.adapter as SpeakerAdapter
            adapter.setList(it.contentsSpeakerList, it.linkList.speakerProfile)
            binding.progressSessionDetail.visibility = View.GONE
        }
    }

    private fun observeFavoriteData() {
        viewModel.favoriteCheck.observe(this) {
            if(it) {
                binding.ivFavoriteSessionDetail.setImageResource(R.drawable.ic_baseline_favorite_24)
            } else {
                binding.ivFavoriteSessionDetail.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }
            binding.ivFavoriteSessionDetail.setOnClickListener { _ ->
                if(it) {
                    viewModel.sessionData.value?.idx?.let { it1 ->
                        viewModel.deleteFavoriteSession(
                            it1
                        )
                    }
                } else {
                    viewModel.sessionData.value?.idx?.let { it1 ->
                        Favorite(
                            it1
                        )
                    }?.let { it2 -> viewModel.insertFavoriteSession(it2) }
                }
            }
        }
    }

    private fun eventProcess() {
        val uri = Uri.parse(viewModel.sessionData.value?.linkList?.video?.get(0)?.url)
        binding.run {
            ivPlaySessionDetail.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }
            ivThumbnailSessionDetail.setOnClickListener {
                startActivity(Intent(Intent.ACTION_VIEW, uri))
            }

            btnShowlistSessionDetail.setOnClickListener {
                parentFragmentManager.popBackStack()
            }
        }
    }

    private fun setImageView() {
        Glide.with(binding.ivThumbnailSessionDetail)
            .load(viewModel.sessionData.value?.parseImageUrl(viewModel.sessionData.value!!))
            .fitCenter()
            .into(binding.ivThumbnailSessionDetail)
    }

    private fun setRecyclerView() {
        binding.rvSpeakerSessionDetail.apply {
            layoutManager = LinearVerticalLayout(context)
            setHasFixedSize(true)
            adapter = SpeakerAdapter()
        }
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
