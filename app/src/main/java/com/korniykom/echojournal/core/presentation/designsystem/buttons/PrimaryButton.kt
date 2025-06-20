package com.korniykom.echojournal.core.presentation.designsystem.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.korniykom.echojournal.core.presentation.designsystem.theme.EchoJournalTheme
import com.korniykom.echojournal.core.presentation.designsystem.theme.buttonGradient

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: (@Composable () -> Unit)? = null
) {
    Button(
        enabled = enabled,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = if(enabled) {
                MaterialTheme.colorScheme.onPrimary
            } else {
                MaterialTheme.colorScheme.outline
            }
        ),
        modifier = modifier.background(
            brush = if(enabled) {
                MaterialTheme.colorScheme.buttonGradient
            } else {
                SolidColor(MaterialTheme.colorScheme.surfaceVariant)
            },
            shape = CircleShape
        )
    ) {
        leadingIcon?.invoke()

        if(leadingIcon != null) {
            Spacer(modifier = Modifier.width(6.dp))
        }

        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge.copy(),
            color = if(enabled) {
                MaterialTheme.colorScheme.onPrimary
            } else {
                MaterialTheme.colorScheme.outline
            }
        )
    }
}

@Preview
@Composable
private fun PrimaryButtonEnablePreview() {
    EchoJournalTheme {
        PrimaryButton(
            text = "Hello World",
            onClick = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Sharp.Done,
                    contentDescription = null
                )
            }
        )
    }
}


@Preview
@Composable
private fun PrimaryButtonDisablePreview() {
    EchoJournalTheme {
        PrimaryButton(
            text = "Hello World",
            onClick = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Sharp.Done,
                    contentDescription = null
                )
            },
            enabled = false
        )
    }
}