package com.survivalcoding.ifkakao.ui.view.filter

import android.widget.ToggleButton
import androidx.core.os.bundleOf
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentSessionFilterBinding
import com.survivalcoding.ifkakao.extension.navigate
import com.survivalcoding.ifkakao.extension.off
import com.survivalcoding.ifkakao.extension.on
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.viewmodel.SessionFilterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SessionFilterFragment : BaseFragment<FragmentSessionFilterBinding, SessionFilterViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_session_filter

    override val viewModel: SessionFilterViewModel by viewModel()

    override fun initStartView() {
        eventProcess()
    }

    override fun getViewModelData() {
        //
    }

    override fun startObserveData() {
        //
    }

    private fun eventProcess() {
        binding.run {
            ivCloseSessionFilter.setOnClickListener {
                navigate(R.id.fragment_session)
            }

            btnServiceSessionFilter.setOnClickListener {
                clickToggleButton(it as ToggleButton)
            }

            btnTechSessionFilter.setOnClickListener {
                clickToggleButton(it as ToggleButton)
            }

            btnBusinessSessionFilter.setOnClickListener {
                clickToggleButton(it as ToggleButton)
            }

            btnResetSessionFilter.setOnClickListener {
                btnServiceSessionFilter.off()
                btnBusinessSessionFilter.off()
                btnTechSessionFilter.off()
            }

            btnApplySessionFilter.setOnClickListener {
                val str = StringBuilder()
                if (btnServiceSessionFilter.isChecked) str.append("서비스,")
                if (btnBusinessSessionFilter.isChecked) str.append("비즈니스,")
                if (btnTechSessionFilter.isChecked) str.append("기술,")
                navigate(R.id.fragment_session, bundleOf("filter" to str.toString()))
            }
        }
    }

    private fun clickToggleButton(view: ToggleButton) {
        if (view.isChecked) {
            view.on()
        } else {
            view.off()
        }
    }

}