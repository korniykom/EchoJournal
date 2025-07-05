package com.korniykom.echojournal.echos.presentation.echos.di

import com.korniykom.echojournal.echos.presentation.echos.EchosViewModel
import com.korniykom.echojournal.echos.presentation.echos.data.recording.AndroidVoiceRecorder
import com.korniykom.echojournal.echos.presentation.echos.domain.recording.VoiceRecorder
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val echosModule = module {
    single {
        AndroidVoiceRecorder(
            context = androidApplication(),
            applicationScope = get()
        )
    } bind VoiceRecorder::class

    viewModelOf(::EchosViewModel)
}