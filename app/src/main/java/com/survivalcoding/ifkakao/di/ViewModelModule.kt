package com.survivalcoding.ifkakao.di

import com.survivalcoding.ifkakao.ui.viewmodel.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { SessionEventMenuViewModel() }
    viewModel { SessionViewModel() }
    viewModel { EventViewModel() }
    viewModel { SessionDetailViewModel() }
}