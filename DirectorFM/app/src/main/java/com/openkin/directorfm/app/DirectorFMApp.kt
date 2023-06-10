package com.openkin.directorfm.app

import android.app.Application
import com.openkin.directorfm.di.appModule
import com.openkin.directorfm.di.dataModule
import com.openkin.directorfm.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class DirectorFMApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@DirectorFMApp)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}