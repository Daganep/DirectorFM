package com.openkin.directorfm.di

import com.openkin.directorfm.viewmodels.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { MainScreenViewModel(mainScreenInteractor =  get()) }
}