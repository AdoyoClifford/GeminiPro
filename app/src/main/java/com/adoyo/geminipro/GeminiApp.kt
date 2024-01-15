package com.adoyo.geminipro

import android.app.Application
import com.adoyo.geminipro.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class GeminiApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GeminiApp)
            modules(appModule)
        }
    }
}