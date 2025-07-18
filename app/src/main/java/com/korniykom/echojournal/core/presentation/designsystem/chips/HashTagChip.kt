package com.korniykom.echojournal.core.presentation.designsystem.chips

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.korniykom.echojournal.core.presentation.designsystem.theme.EchoJournalTheme
import com.korniykom.echojournal.core.presentation.designsystem.theme.Gray6

@Composable
fun HashtagChip(
    modifier: Modifier = Modifier,
    text: String,
    trailingIcon: (@Composable () -> Unit)? = null,
) {
    Surface(
        shape = CircleShape,
        color = Gray6,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
            .background(Gray6)
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "#",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = text
            )
            trailingIcon?.invoke()
        }
    }
}

@Preview
@Composable
private fun HashtagChipPreview() {
    EchoJournalTheme {
        HashtagChip(
            text = "Hello world",
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp)
                )
            },
        )
    }
}