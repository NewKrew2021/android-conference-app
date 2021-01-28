package com.survivalcoding.ifkakao.ui.view

import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.survivalcoding.ifkakao.R
import com.survivalcoding.ifkakao.databinding.ActivityMainBinding
import com.survivalcoding.ifkakao.ui.base.BaseActivity
import com.survivalcoding.ifkakao.ui.view.home.MainFragment
import com.survivalcoding.ifkakao.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutResourceId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel by viewModel()

    override fun initStartView() {
        //
    }

    override fun getViewModelData() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    override fun startObserveData() {
        //
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<MainFragment>(R.id.fragment_container_view, "main")
            }
        }
    }


}