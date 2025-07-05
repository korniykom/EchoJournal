package com.korniykom.echojournal.echos.presentation.echos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.korniykom.echojournal.R
import com.korniykom.echojournal.core.presentation.designsystem.dropdowns.Selectable
import com.korniykom.echojournal.core.presentation.utils.UiText
import com.korniykom.echojournal.echos.presentation.echos.domain.recording.VoiceRecorder
import com.korniykom.echojournal.echos.presentation.echos.models.AudioCaptureMethod
import com.korniykom.echojournal.echos.presentation.echos.models.EchoFilterChip
import com.korniykom.echojournal.echos.presentation.echos.models.MoodChipContent
import com.korniykom.echojournal.echos.presentation.models.MoodUi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class EchosViewModel(
    private val voiceRecorder: VoiceRecorder
) : ViewModel() {

    private var hasLoadedInitialData = false

    private val selectedMoodFilters = MutableStateFlow<List<MoodUi>>(emptyList())
    private val selectedTopicFilters = MutableStateFlow<List<String>>(emptyList())

    private val eventChannel = Channel<EchoEvent>()
    val events = eventChannel.receiveAsFlow()

    private val _state = MutableStateFlow(EchosState())
    val state = _state
        .onStart {
            if(!hasLoadedInitialData) {
                observeFilters()
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
            EchosActions.OnFabClick -> {
                requestAudioPermission()
                _state.update { it.copy(
                    currentCaptureMethod = AudioCaptureMethod.STANDART
                )
                }
            }
            EchosActions.OnFabLongClick -> {
                requestAudioPermission()
                _state.update { it.copy(
                    currentCaptureMethod = AudioCaptureMethod.QUICK
                )
                }
            }
            EchosActions.OnMoodChipClick -> {
                _state.update { it.copy(
                    selectedEchoFilterChip = EchoFilterChip.MOODS
                )}
            }
            is EchosActions.OnRemoveFilters -> {
                when(action.filterType) {
                    EchoFilterChip.MOODS -> selectedMoodFilters.update { emptyList() }
                    EchoFilterChip.TOPICS -> selectedTopicFilters.update { emptyList() }
                }
            }
            EchosActions.OnTopicChipClick -> {
                _state.update { it.copy(
                    selectedEchoFilterChip = EchoFilterChip.TOPICS
                )}
            }
            EchosActions.OnSettingsClick -> {}
            EchosActions.OnDismissTopicDropDown,
            EchosActions.OnDismissMoodDropDown -> {
                _state.update { it.copy(
                    selectedEchoFilterChip = null
                ) }
            }
            is EchosActions.OnFilterByMoodClick -> {
                toggleMoodFilter(action.moodUi)
            }
            is EchosActions.OnFilterByTopicClick -> {
                toggleTopicFilter(action.topic)
            }

            EchosActions.OnPauseClick -> {}
            is EchosActions.OnPlayEchoClick -> {}
            is EchosActions.OnTrackSizeAvailable -> {}
            EchosActions.OnAudioPermissionGranted -> {}
        }
    }

    private fun requestAudioPermission() = viewModelScope.launch {

    }

    private fun toggleMoodFilter(moodUi: MoodUi) {
        selectedMoodFilters.update { selectedMoods ->
            if(moodUi in selectedMoods) {
                selectedMoods - moodUi
            } else {
                selectedMoods + moodUi
            }

        }
    }

    private fun toggleTopicFilter(topic: String) {
        selectedTopicFilters.update { selectedTopics ->
            if(topic in selectedTopics) {
                selectedTopics - topic
            } else {
                selectedTopics + topic
            }

        }
        _state.update { it.copy(
            selectedEchoFilterChip = EchoFilterChip.TOPICS
        ) }
    }

    private fun observeFilters() {
        combine(
            selectedTopicFilters,
            selectedMoodFilters
        ) { selectedTopics, selectedMoods ->
            _state.update { it.copy(
                topics = it.topics.map{ selectableTopic ->
                    Selectable(
                        item = selectableTopic.item,
                        selected = selectedTopics.contains(selectableTopic.item)
                    )
                },
                moods = MoodUi.entries.map {
                    Selectable(
                        item = it,
                        selected = selectedMoods.contains(it)
                    )
                },
                hasActiveMoodFilters = selectedMoods.isNotEmpty(),
                hasActiveTopicFilters = selectedTopics.isNotEmpty(),
                topicChipTitle = selectedTopics.derivedTopicsToText(),
                moodChipContent = selectedMoods.asMoodChipContent()
            ) }
        }.launchIn(viewModelScope)
    }
    private fun List<String>.derivedTopicsToText() : UiText {
        return when(size) {
            0 -> UiText.StringResource(R.string.all_topics)
            1 -> UiText.Dynamic(this.first())
            2 -> UiText.Dynamic("${this.first()}, ${this.last()}")
            else -> {
                val extraElementCount = size - 2
                UiText.Dynamic("${this.first()}, ${this[1]} +$extraElementCount")
            }
        }
    }

    private fun List<MoodUi>.asMoodChipContent(): MoodChipContent {
        if(this.isEmpty()) {
            return MoodChipContent()
        }

        val icons = this.map { it.iconSet.fill }
        val moodNames = this.map { it.title}
        return when(size) {
            1 -> MoodChipContent(
                iconsRes = icons,
                title = moodNames.first()
            )
            2 -> MoodChipContent(
                iconsRes = icons,
                title = ("${moodNames.first()}, ${moodNames[1]}")
            )
            else -> {
                val extraElementCount = this.size - 2
                MoodChipContent(
                    iconsRes = icons,
                    title = ("${moodNames.first()}, ${moodNames[1]} +$extraElementCount")
                )
            }
        }
    }
}