package com.korniykom.echojournal.echos.presentation.echos

import com.korniykom.echojournal.echos.presentation.echos.models.EchoFilterChip
import com.korniykom.echojournal.echos.presentation.echos.models.TrackSizeInfo
import com.korniykom.echojournal.echos.presentation.models.MoodUi

sealed interface EchosActions {
    data object OnMoodChipClick : EchosActions
    data object OnDismissMoodDropDown: EchosActions
    data class OnFilterByMoodClick(val moodUi: MoodUi): EchosActions
    data object OnTopicChipClick : EchosActions
    data object OnDismissTopicDropDown: EchosActions
    data class OnFilterByTopicClick(val topic: String): EchosActions
    data object OnFabClick : EchosActions
    data object OnFabLongClick : EchosActions
    data object OnSettingsClick: EchosActions
    data class OnRemoveFilters(val filterType: EchoFilterChip) : EchosActions
    data class OnPlayEchoClick(val echoId: Int): EchosActions
    data object OnPauseClick: EchosActions
    data class OnTrackSizeAvailable(val trackSizeInfo: TrackSizeInfo): EchosActions
    data object OnAudioPermissionGranted: EchosActions

}