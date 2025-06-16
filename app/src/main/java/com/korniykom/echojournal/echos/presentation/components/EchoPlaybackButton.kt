package com.korniykom.echojournal.echos.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.korniykom.echojournal.core.presentation.designsystem.theme.EchoJournalTheme
import com.korniykom.echojournal.core.presentation.designsystem.theme.Pause
import com.korniykom.echojournal.core.presentation.utils.defaultShadow
import com.korniykom.echojournal.echos.presentation.models.MoodUi
import com.korniykom.echojournal.echos.presentation.models.PlaybackState

@Composable
fun EchoPlaybackButton(
    playbackState: PlaybackState,
    onPlayClick: () -> Unit,
    onPauseClick: () -> Unit,
    colors: IconButtonColors,
    modifier: Modifier = Modifier
) {
    FilledIconButton(
        onClick = when(playbackState) {
            PlaybackState.PLAYING -> onPlayClick

            PlaybackState.STOPPED,
            PlaybackState.PAUSED -> onPauseClick
        },
        colors = colors,
        modifier = modifier.defaultShadow()
    ) {
        Icon(
            imageVector = when(playbackState) {
                PlaybackState.PLAYING -> Icons.Filled.Pause
                PlaybackState.STOPPED -> Icons.Filled.PlayArrow
                PlaybackState.PAUSED -> Icons.Filled.PlayArrow
            },
            contentDescription = playbackState.toString()
        )
    }
}

@Preview
@Composable
private fun EchoPlaybackButtonPreview() {
    EchoJournalTheme {
        EchoPlaybackButton(
            playbackState = PlaybackState.PAUSED,
            onPlayClick = {},
            onPauseClick = {},
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MoodUi.SAD.colorSet.vivid
            ),
        )
    }
}