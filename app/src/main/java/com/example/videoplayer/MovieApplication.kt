package com.example.videoplayer

import android.app.Application
import com.example.home.di.homeModule
import com.example.videoplayer.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MovieApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MovieApplication)
            modules(appModule)
            modules(homeModule)
        }
    }
}