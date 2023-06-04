package com.openkin.directorfm.di

import com.openkin.domain.interactors.IMainScreenInteractor
import com.openkin.domain.interactors.MainScreenInteractor
import org.koin.dsl.module

val domainModule = module {

    single<IMainScreenInteractor> {
        MainScreenInteractor(mainScreenRepository = get())
    }
}