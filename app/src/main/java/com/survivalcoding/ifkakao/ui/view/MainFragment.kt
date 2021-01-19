package com.survivalcoding.ifkakao.ui.view

import android.widget.ScrollView
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.FragmentMainBinding
import com.survivalcoding.ifkakao.ui.base.BaseFragment
import com.survivalcoding.ifkakao.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.fragment_main

    override val viewModel: MainViewModel by viewModel()

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
        binding.ivUpScrollMain.setOnClickListener{
            binding.svMain.fullScroll(ScrollView.FOCUS_UP)
        }
    }
}