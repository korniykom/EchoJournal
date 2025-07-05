package com.korniykom.echojournal.app

import android.app.Application
import com.korniykom.echojournal.app.di.appModule
import com.korniykom.echojournal.echos.presentation.echos.di.echosModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EchoJournalApp: Application() {
    val applicationScope = CoroutineScope(Dispatchers.Default + SupervisorJob())

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@EchoJournalApp)
            modules(
                appModule,
                echosModule
            )
        }
    }
}