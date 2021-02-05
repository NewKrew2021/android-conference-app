package com.survivalcoding.ifkakao.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.observe

abstract class BaseFragment<T : ViewDataBinding, R : ViewModel> : Fragment() {

    lateinit var binding: T

    abstract val layoutResourceId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)
        return binding.root
    }

    inline fun <reified T> LiveData<T>.observe(noinline observer: (T) -> Unit) {
        observe(viewLifecycleOwner, observer)
    }
}