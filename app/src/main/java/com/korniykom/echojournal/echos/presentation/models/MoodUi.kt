package com.korniykom.echojournal.echos.presentation.models

import androidx.annotation.DrawableRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.korniykom.echojournal.R
import com.korniykom.echojournal.core.presentation.designsystem.theme.Excited25
import com.korniykom.echojournal.core.presentation.designsystem.theme.Excited35
import com.korniykom.echojournal.core.presentation.designsystem.theme.Excited80
import com.korniykom.echojournal.core.presentation.designsystem.theme.Neutral25
import com.korniykom.echojournal.core.presentation.designsystem.theme.Neutral35
import com.korniykom.echojournal.core.presentation.designsystem.theme.Neutral80
import com.korniykom.echojournal.core.presentation.designsystem.theme.Peaceful25
import com.korniykom.echojournal.core.presentation.designsystem.theme.Peaceful35
import com.korniykom.echojournal.core.presentation.designsystem.theme.Peaceful80
import com.korniykom.echojournal.core.presentation.designsystem.theme.Sad25
import com.korniykom.echojournal.core.presentation.designsystem.theme.Sad35
import com.korniykom.echojournal.core.presentation.designsystem.theme.Sad80
import com.korniykom.echojournal.core.presentation.designsystem.theme.Stressed25
import com.korniykom.echojournal.core.presentation.designsystem.theme.Stressed35
import com.korniykom.echojournal.core.presentation.designsystem.theme.Stressed80
import com.korniykom.echojournal.core.presentation.utils.UiText

enum class MoodUi(
    val iconSet: MoodIconSet,
    val colorSet: MoodColorSet,
    val title: String
) {
    STRESSED(
        iconSet = MoodIconSet(
            fill = R.drawable.emoji_stressed,
            outline = R.drawable.emoji_stressed_outline
        ),
        colorSet = MoodColorSet(
            vivid = Stressed80,
            desaturated = Stressed35,
            faded = Stressed25,
        ),
        title = "Stressed"
    ),
    SAD(
        iconSet = MoodIconSet(
            fill = R.drawable.emoji_sad,
            outline = R.drawable.emoji_sad_outline
        ),
        colorSet = MoodColorSet(
            vivid = Sad80,
            desaturated = Sad35,
            faded = Sad25,
        ),
        title = "Sad"    ),
    NEUTRAL(
        iconSet = MoodIconSet(
            fill = R.drawable.emoji_neutral,
            outline = R.drawable.emoji_neutral_outline
        ),
        colorSet = MoodColorSet(
            vivid = Neutral80,
            desaturated = Neutral35,
            faded = Neutral25,
        ),
        title = "Neutral"    ),
    PEACEFUL(
        iconSet = MoodIconSet(
            fill = R.drawable.emoji_peaceful,
            outline = R.drawable.emoji_peaceful_outline
        ),
        colorSet = MoodColorSet(
            vivid = Peaceful80,
            desaturated = Peaceful35,
            faded = Peaceful25,
        ),
        title = "Peaceful"    ),
    EXCITED(
        iconSet = MoodIconSet(
            fill = R.drawable.emoji_excited,
            outline = R.drawable.emoji_excited_outline
        ),
        colorSet = MoodColorSet(
            vivid = Excited80,
            desaturated = Excited35,
            faded = Excited25,
        ),
        title = "Excited"    )
}

data class MoodIconSet (
    @DrawableRes val fill: Int,
    @DrawableRes val outline: Int
)

data class MoodColorSet (
    val vivid: Color,
    val desaturated: Color,
    val faded: Color
)