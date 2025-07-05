package com.korniykom.echojournal.echos.presentation.echos.domain.recording

import kotlinx.coroutines.flow.Flow

interface VoiceRecorder {
    val recordingDetails: Flow<RecordingDetails>
    fun start()
    fun pause()
    fun stop()
    fun resume()
    fun cancel()
}