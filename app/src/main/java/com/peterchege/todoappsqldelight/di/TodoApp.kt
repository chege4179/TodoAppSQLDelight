package com.peterchege.todoappsqldelight.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TodoApp :Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@TodoApp)
            modules(appModule)
        }
    }
}