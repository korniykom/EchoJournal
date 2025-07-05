package com.korniykom.echojournal.echos.presentation.preview


import com.korniykom.echojournal.echos.presentation.models.EchoUi
import com.korniykom.echojournal.echos.presentation.models.MoodUi
import com.korniykom.echojournal.echos.presentation.models.PlaybackState
import java.time.Instant
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds

data object PreviewModels {

    val echoUi = EchoUi(
        id = 0,
        title = "My audio memo",
        mood = MoodUi.STRESSED,
        recordedAt = Instant.now(),
        note = (1..50).map { "Hello" }.joinToString(" "),
        topics = listOf("Love", "Work"),
        amplitudes = (1..30).map { Random.nextFloat() },
        playbackTotalDuration = 250.seconds,
        playbackCurrentDuration = 120.seconds,
        playbackState = PlaybackState.PAUSED
    )
}