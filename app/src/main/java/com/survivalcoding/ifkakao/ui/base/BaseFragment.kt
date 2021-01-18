package com.survivalcoding.ifkakao.ui.base

import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<T : ViewDataBinding, R : ViewModel> : Fragment(){

    lateinit var binding: T

    abstract val layoutResourceId: Int

    abstract val viewModel: R

    abstract fun initStartView()

    abstract fun getViewModelData()

    abstract fun startObserveData()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initStartView()
        getViewModelData()
        startObserveData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,layoutResourceId, container, false)
        return binding.root
    }
}