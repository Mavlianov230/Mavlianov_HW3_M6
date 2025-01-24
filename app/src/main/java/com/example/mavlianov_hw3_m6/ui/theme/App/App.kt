package com.example.mavlianov_hw3_m6.ui.theme.App

import android.app.Application
import com.example.mavlianov_hw3_m6.ui.theme.Data.ServiceLocator.dataModul
import com.example.mavlianov_hw3_m6.ui.theme.ServiceLocator.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(dataModul, uiModule)
        }
    }
}