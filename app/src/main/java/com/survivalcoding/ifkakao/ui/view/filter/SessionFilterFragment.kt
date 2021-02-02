package com.survivalcoding.ifkakao.ui.view.filter

import android.os.Bundle
import android.view.View
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClick()
    }

    private fun setOnClick() {
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
                if (btnServiceSessionFilter.isChecked) str.append(SERVICE_CHECK)
                if (btnBusinessSessionFilter.isChecked) str.append(BUSINESS_CHECK)
                if (btnTechSessionFilter.isChecked) str.append(TECH_CHECK)
                navigate(R.id.fragment_session, bundleOf(KEY_OF_FILTER_BUNDLE to str.toString()))
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

    companion object {
        const val SERVICE_CHECK = "서비스,"
        const val BUSINESS_CHECK = "비즈니스,"
        const val TECH_CHECK = "기술,"
        const val KEY_OF_FILTER_BUNDLE = "filter"
    }

}