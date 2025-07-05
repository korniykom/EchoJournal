package com.korniykom.echojournal.app

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.core.app.ActivityCompat
import com.korniykom.echojournal.core.presentation.designsystem.theme.EchoJournalTheme
import com.korniykom.echojournal.echos.presentation.echos.EchosRoot
import com.korniykom.echojournal.echos.presentation.echos.data.recording.AndroidVoiceRecorder
import com.korniykom.echojournal.echos.presentation.echos.domain.recording.VoiceRecorder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.RECORD_AUDIO),
            0
        )
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val recorder = AndroidVoiceRecorder(
            context = applicationContext,
            applicationScope = (application as EchoJournalApp).applicationScope
        )
        setContent {
            EchoJournalTheme {
              EchosRoot()
            }
        }
    }
}
