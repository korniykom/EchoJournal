package com.korniykom.echojournal.echos.presentation.echos.models

import com.korniykom.echojournal.core.presentation.utils.UiText
import com.korniykom.echojournal.echos.presentation.models.EchoUi

data class EchoDaySection(
    val dateHeader: UiText,
    val echos: List<EchoUi>
)