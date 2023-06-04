package com.openkin.directorfm.di

import com.openkin.data.repositories.MainScreenRepository
import com.openkin.domain.irepositories.IMainScreenRepository
import org.koin.dsl.module

val dataModule = module {

    single<IMainScreenRepository> {
        MainScreenRepository()
    }
}