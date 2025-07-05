package com.korniykom.echojournal.echos.presentation.echos

import com.korniykom.echojournal.R
import com.korniykom.echojournal.core.presentation.designsystem.dropdowns.Selectable
import com.korniykom.echojournal.core.presentation.designsystem.dropdowns.Selectable.Companion.asUnselectedItems
import com.korniykom.echojournal.core.presentation.utils.UiText
import com.korniykom.echojournal.echos.presentation.echos.models.AudioCaptureMethod
import com.korniykom.echojournal.echos.presentation.echos.models.EchoDaySection
import com.korniykom.echojournal.echos.presentation.echos.models.EchoFilterChip
import com.korniykom.echojournal.echos.presentation.echos.models.MoodChipContent
import com.korniykom.echojournal.echos.presentation.models.EchoUi
import com.korniykom.echojournal.echos.presentation.models.MoodUi

data class EchosState(
    val echos: Map<UiText, List<EchoUi>> = emptyMap(),
    val currentCaptureMethod: AudioCaptureMethod? = null,
    val hasEchosRecorded: Boolean = false,
    val hasActiveTopicFilters: Boolean = false,
    val hasActiveMoodFilters: Boolean = false,
    val isLoadingData: Boolean = false,
    val moods: List<Selectable<MoodUi>> = listOf(),
    val topics: List<Selectable<String>> = listOf("Love", "Happy", "Work").asUnselectedItems(),
    val moodChipContent: MoodChipContent = MoodChipContent(),
    val selectedEchoFilterChip: EchoFilterChip? = null,
    val topicChipTitle: UiText = UiText.StringResource(R.string.all_topics)
) {
    val echoDaySection = echos
        .toList()
        .map{(dateHeader, echos) ->
            EchoDaySection(dateHeader, echos)
        }
}