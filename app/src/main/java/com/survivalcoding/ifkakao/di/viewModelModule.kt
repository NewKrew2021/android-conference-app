package com.survivalcoding.ifkakao.di

import com.survivalcoding.ifkakao.ui.viewmodel.MainViewModel
import com.survivalcoding.ifkakao.ui.viewmodel.SessionEventMenuViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { SessionEventMenuViewModel() }
}