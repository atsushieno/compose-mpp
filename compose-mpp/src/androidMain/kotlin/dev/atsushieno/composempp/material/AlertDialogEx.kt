package dev.atsushieno.composempp.material

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

@Composable
@ExperimentalMaterialApi
internal actual fun AlertDialogEx(
    // FIXME: they are defined as nullable but they indeed aren't. See https://issuetracker.google.com/issues/194625542
    onDismissRequest: (() -> Unit)?,
    confirmButton: @Composable (() -> Unit)?,
    modifier: Modifier?,
    dismissButton: @Composable (() -> Unit)?,
    title: @Composable (() -> Unit)?,
    text: @Composable (() -> Unit)?,
    shape: Shape?,
    backgroundColor: Color?,
    contentColor: Color?
) {
    @OptIn(ExperimentalComposeUiApi::class)
    androidx.compose.material.AlertDialog(onDismissRequest!!, confirmButton!!, modifier!!, dismissButton, title, text, shape!!, backgroundColor!!, contentColor!!)
}

@Composable
@ExperimentalMaterialApi
internal actual fun AlertDialogEx(
    // FIXME: they are defined as nullable but they indeed aren't. See https://issuetracker.google.com/issues/194625542
    onDismissRequest: (() -> Unit)?,
    buttons: @Composable (() -> Unit)?,
    modifier: Modifier?,
    title: (@Composable () -> Unit)?,
    text: @Composable (() -> Unit)?,
    shape: Shape?,
    backgroundColor: Color?,
    contentColor: Color?
) {
    @OptIn(ExperimentalComposeUiApi::class)
    androidx.compose.material.AlertDialog(onDismissRequest!!, buttons!!, modifier!!, title, text, shape!!, backgroundColor!!, contentColor!!)
}
