package com.survivalcoding.ifkakao.ui.view.menu

import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentSessionEventMenuBinding
import com.survivalcoding.ifkakao.extension.navigate
import com.survivalcoding.ifkakao.extension.popBackStack
import com.survivalcoding.ifkakao.ui.base.BaseFragment
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
                popBackStack()
            }

            tvSessionSessionEvent.setOnClickListener {
                navigate(R.id.fragment_session)
            }

            tvEventSessionEvent.setOnClickListener {
                navigate(R.id.fragment_event)
            }
        }
    }
}