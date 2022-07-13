package com.example.main_koin.core

import android.app.Application
import com.example.main_koin.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CoreApp: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CoreApp)
            modules(dataModule())
        }
    }
}