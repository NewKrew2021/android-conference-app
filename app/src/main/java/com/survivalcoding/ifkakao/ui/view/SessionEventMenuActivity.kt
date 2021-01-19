package com.survivalcoding.ifkakao.ui.view

import android.widget.Toast
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.ActivitySessionEventMenuBinding
import com.survivalcoding.ifkakao.ui.base.BaseActivity
import com.survivalcoding.ifkakao.ui.viewmodel.SessionEventMenuViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SessionEventMenuActivity :
    BaseActivity<ActivitySessionEventMenuBinding, SessionEventMenuViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.activity_session_event_menu

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
                finish()
            }

            tvSessionSessionEvent.setOnClickListener {
                Toast.makeText(applicationContext, "go session fragment", Toast.LENGTH_SHORT).show()
            }

            tvEventSessionEvent.setOnClickListener {
                Toast.makeText(applicationContext, "go event fragment", Toast.LENGTH_SHORT).show()
            }
        }
    }
}