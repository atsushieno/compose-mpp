package dev.atsushieno.common

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.atsushieno.composempp.material.AlertDialog
import dev.atsushieno.composempp.material.DropdownMenu

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun App() {
    var dropDownIsOpen by remember { mutableStateOf(false) }

    Button(onClick = { dropDownIsOpen = !dropDownIsOpen }) {
        Text("Show DropDown")
    }
    DropdownMenu(
        dropDownIsOpen,
        { dropDownIsOpen = false}
    ) {
        Row(Modifier.padding(4.dp)) {
            Text("Item")
        }
        Row(Modifier.padding(4.dp)) {
            Text("Item 1")
        }
        Row(Modifier.padding(4.dp)) {
            Text("Item 2")
        }
    }
}

