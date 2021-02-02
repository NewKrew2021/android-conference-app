package com.survivalcoding.ifkakao.ui.view.session

import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.data.model.entity.Favorite
import com.survivalcoding.ifkakao.data.model.response.ConferenceSessionResponse
import com.survivalcoding.ifkakao.databinding.FragmentSessionDetailBinding
import com.survivalcoding.ifkakao.extension.initToLinearLayout
import com.survivalcoding.ifkakao.extension.navigate
import com.survivalcoding.ifkakao.extension.setToolbar
import com.survivalcoding.ifkakao.extension.stop
import com.survivalcoding.ifkakao.ui.adapter.SpeakerAdapter
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.viewmodel.SessionDetailViewModel
import com.survivalcoding.ifkakao.util.SESSION_ITEM
import org.koin.androidx.viewmodel.ext.android.viewModel

class SessionDetailFragment : BaseFragment<FragmentSessionDetailBinding, SessionDetailViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_session_detail

    override val viewModel: SessionDetailViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this
        getData()
        setView()
        subscribeUI()

    }

    private fun getData() {
        getBundleData()
        getViewModelData()
    }

    private fun getBundleData() {
        arguments?.let {
            viewModel.setConferenceSessionData(it.getParcelable(SESSION_ITEM))
        }
    }

    private fun getViewModelData() {
        viewModel.getFavoriteSessionData()
        binding.videoUri = Uri.parse(viewModel.sessionData.value?.linkList?.video?.get(0)?.url)
    }

    private fun setView() {
        setToolbar(binding.include.toolbarMain, binding.include.tvTitleMain)
        setImageView()
        setRecyclerView()
    }

    private fun setImageView() {
        Glide.with(binding.ivThumbnailSessionDetail)
            .load(viewModel.sessionData.value?.parseImageUrl(viewModel.sessionData.value!!))
            .fitCenter()
            .into(binding.ivThumbnailSessionDetail)
    }

    private fun setRecyclerView() {
        binding.rvSpeakerSessionDetail.initToLinearLayout(
            layoutType = LinearLayoutManager.VERTICAL,
            isDivider = false,
            adapter = SpeakerAdapter()
        )
    }

    private fun subscribeUI() = with(viewModel) {
        sessionData.observe { setSessionDetailData(it) }
        favoriteCheck.observe { onClickFavorite(it) }
    }

    private fun setSessionDetailData(data: ConferenceSessionResponse) {
        binding.run {
            tvFiledSessionDetail.text = data.field
            tvTitleSessionDetail.text = data.parseString(data.title)
            tvContentsSessionDetail.text = data.parseString(data.content)
            tvHashtagSessionDetail.text = data.contentTag
        }

        val adapter = binding.rvSpeakerSessionDetail.adapter as SpeakerAdapter
        adapter.setList(data.contentsSpeakerList, data.linkList.speakerProfile)
        binding.progressSessionDetail.stop()
    }

    private fun onClickFavorite(favoriteState: Boolean) {
        if (favoriteState) {
            binding.ivFavoriteSessionDetail.setImageResource(R.drawable.ic_baseline_favorite_24)
        } else {
            binding.ivFavoriteSessionDetail.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }
        binding.ivFavoriteSessionDetail.setOnClickListener { _ ->
            if (favoriteState) {
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
