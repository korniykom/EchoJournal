package com.korniykom.echojournal.echos.presentation.echos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class EchosViewModel : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(EchosState())
    val state = _state
        .onStart {
            if(!hasLoadedInitialData) {
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = EchosState()
        )
    fun onAction(action: EchosActions) {
        when(action) {
            EchosActions.OnFabClick -> {}
            EchosActions.OnFabLongClick -> {}
            EchosActions.OnMoodChipClick -> {}
            is EchosActions.OnRemoveFilters -> {}
            EchosActions.OnTopicChipClick -> {}
            EchosActions.OnSettingsClick -> {}
        }
    }
}