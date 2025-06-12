package com.korniykom.echojournal.echos.presentation.echos

import com.korniykom.echojournal.echos.presentation.echos.models.EchoFilterChip

sealed interface EchosActions {
    data object OnMoodChipClick : EchosActions
    data object OnTopicChipClick : EchosActions
    data object OnFabClick : EchosActions
    data object OnFabLongClick : EchosActions
    data object OnSettingsClick: EchosActions
    data class OnRemoveFilters(val filterType: EchoFilterChip) : EchosActions
}