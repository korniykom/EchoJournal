package com.korniykom.echojournal.core.presentation.designsystem.buttons

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.korniykom.echojournal.core.presentation.designsystem.theme.EchoJournalTheme

@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ),
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge.copy(),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview
@Composable
private fun SecondaryButtonPreview() {
    EchoJournalTheme {
        SecondaryButton(
            text = "Hello World",
            onClick = {},
        )
    }
}