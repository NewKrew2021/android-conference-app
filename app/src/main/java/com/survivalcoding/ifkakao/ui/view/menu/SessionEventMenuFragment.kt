package com.survivalcoding.ifkakao.ui.view.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentSessionEventMenuBinding
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.viewmodel.SessionEventMenuViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SessionEventMenuFragment :
    BaseFragment<FragmentSessionEventMenuBinding, SessionEventMenuViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_session_event_menu

    private val viewModel: SessionEventMenuViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this
    }

}