package dev.atsushieno.composempp.samples.alertdialog

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import dev.atsushieno.composempp.material.AlertDialog

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun App() {
    var dialogState by remember { mutableStateOf(false) }

    Button(onClick = { dialogState = true }) { Text("Show Dialog") }
    if (dialogState) {
        AlertDialog(
            onDismissRequest = { dialogState = false },
            confirmButton = { Button(onClick = { dialogState = false }) { Text("OK") } },
            title = { Text("TITLE") },
            text = { Text("message") },
        )
    }
}
