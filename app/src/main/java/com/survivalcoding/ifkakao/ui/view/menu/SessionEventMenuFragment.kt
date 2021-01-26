package com.survivalcoding.ifkakao.ui.view.menu

import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentSessionEventMenuBinding
import com.survivalcoding.ifkakao.extension.replaceFragment
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.view.event.EventFragment
import com.survivalcoding.ifkakao.ui.view.session.SessionFragment
import com.survivalcoding.ifkakao.ui.viewmodel.SessionEventMenuViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SessionEventMenuFragment :
    BaseFragment<FragmentSessionEventMenuBinding, SessionEventMenuViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_session_event_menu

    override val viewModel: SessionEventMenuViewModel by viewModel()

    override fun initStartView() {
        eventProcess()
    }

    override fun getViewModelData() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    override fun startObserveData() {
        //
    }

    private fun eventProcess() {

        binding.run {
            ivCloseSessionEventMenu.setOnClickListener {
                replaceFragment<SessionFragment>(R.id.fragment_container_view)
            }

            tvSessionSessionEvent.setOnClickListener {
                replaceFragment<SessionFragment>(R.id.fragment_container_view)
            }

            tvEventSessionEvent.setOnClickListener {
                replaceFragment<EventFragment>(R.id.fragment_container_view)
            }
        }
    }
}