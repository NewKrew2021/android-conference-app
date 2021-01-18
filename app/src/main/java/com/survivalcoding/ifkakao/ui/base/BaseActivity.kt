package com.survivalcoding.ifkakao.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel

abstract class BaseActivity<T : ViewDataBinding, R : ViewModel> : AppCompatActivity(){

    lateinit var binding: T

    abstract val layoutResourceId: Int

    abstract val viewModel: R

    abstract fun initStartView()

    abstract fun getViewModelData()

    abstract fun startObserveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutResourceId)

        initStartView()
        getViewModelData()
        startObserveData()
    }
}