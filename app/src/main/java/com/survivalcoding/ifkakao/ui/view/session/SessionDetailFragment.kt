package com.survivalcoding.ifkakao.ui.view.session

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.data.model.response.ConferenceSessionResponse
import com.survivalcoding.ifkakao.databinding.FragmentSessionDetailBinding
import com.survivalcoding.ifkakao.extension.replaceFragment
import com.survivalcoding.ifkakao.extension.setToolbar
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.view.menu.SessionEventMenuFragment
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
            val url = it.getParcelable<ConferenceSessionResponse>(SESSION_ITEM)?.linkList?.video?.get(0)?.url
            Toast.makeText(context, url, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getViewModelData() {
        //
    }

    override fun startObserveData() {
        //
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar_menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_main -> {
                replaceFragment<SessionEventMenuFragment>(R.id.fragment_container_view)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}