package com.survivalcoding.ifkakao.ui.view.menu

import android.os.Bundle
import android.view.View
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClick()
    }

    private fun setOnClick() {
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