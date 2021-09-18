package dev.atsushieno.composempp.material

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

// https://github.com/JetBrains/compose-jb/issues/762

// AlertDialog() is implemented to avoid expect/actual, due to some issues:
// - https://issuetracker.google.com/issues/194625542
// - https://kotlinlang.slack.com/archives/C01D6HTPATV/p1631907038318800

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AlertDialog(
    onDismissRequest: (() -> Unit),
    confirmButton: @Composable (() -> Unit),
    modifier: Modifier = Modifier,
    dismissButton: @Composable (() -> Unit) = {},
    title: @Composable (() -> Unit) = {},
    text: @Composable (() -> Unit) = {},
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor)
) = AlertDialogEx(onDismissRequest, confirmButton, modifier, dismissButton, title, text, shape, backgroundColor, contentColor)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AlertDialog(
    // FIXME: they are defined as nullable but they indeed aren't. See https://issuetracker.google.com/issues/194625542
    onDismissRequest: (() -> Unit),
    buttons: @Composable (() -> Unit),
    modifier: Modifier = Modifier,
    title: (@Composable () -> Unit),
    text: @Composable (() -> Unit),
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor)
) = AlertDialogEx(onDismissRequest, buttons, modifier, title, text, shape, backgroundColor, contentColor)

@Composable
expect fun AlertDialogEx(
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
)

@Composable
expect fun AlertDialogEx(
    // FIXME: they are defined as nullable but they indeed aren't. See https://issuetracker.google.com/issues/194625542
    onDismissRequest: (() -> Unit)?,
    buttons: @Composable (() -> Unit)?,
    modifier: Modifier?,
    title: (@Composable () -> Unit)?,
    text: @Composable (() -> Unit)?,
    shape: Shape?,
    backgroundColor: Color?,
    contentColor: Color?
)
