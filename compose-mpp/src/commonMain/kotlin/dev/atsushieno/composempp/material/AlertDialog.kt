package dev.atsushieno.composempp.material

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

@ExperimentalMaterialApi
@Composable
fun AlertDialog(
    onDismissRequest: (() -> Unit),
    buttons: @Composable (() -> Unit),
    modifier: Modifier = Modifier,
    title: (@Composable () -> Unit),
    text: @Composable (() -> Unit),
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor)
) {
    AlertDialogInternal(onDismissRequest, buttons, modifier, title, text, shape, backgroundColor, contentColor)
}

@ExperimentalMaterialApi
@Composable
fun AlertDialog(
    // FIXME: they are defined as nullable but they indeed aren't. See https://issuetracker.google.com/issues/194625542
    onDismissRequest: (() -> Unit),
    confirmButton: @Composable (() -> Unit),
    modifier: Modifier,
    dismissButton: @Composable (() -> Unit)?,
    title: @Composable (() -> Unit)?,
    text: @Composable (() -> Unit)?,
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor)
) {
    AlertDialogInternal2(onDismissRequest, confirmButton, modifier, dismissButton, title, text, shape, backgroundColor, contentColor)
}

// Since there are compose compiler plugin issues that prevent default arguments, those expect/actual functions are implemented as internal.
// https://issuetracker.google.com/issues/194625542
// https://github.com/JetBrains/compose-jb/issues/762
@Composable
internal expect fun AlertDialogInternal(
    onDismissRequest: (() -> Unit),
    buttons: @Composable (() -> Unit),
    modifier: Modifier,
    title: (@Composable () -> Unit)?,
    text: @Composable (() -> Unit)?,
    shape: Shape,
    backgroundColor: Color,
    contentColor: Color
)

// Since there are compose compiler plugin issues that prevent default arguments, those expect/actual functions are implemented as internal.
// https://issuetracker.google.com/issues/194625542
// https://github.com/JetBrains/compose-jb/issues/762
@Composable
internal expect fun AlertDialogInternal2(
    onDismissRequest: (() -> Unit),
    confirmButton: @Composable (() -> Unit),
    modifier: Modifier,
    dismissButton: @Composable (() -> Unit)?,
    title: @Composable (() -> Unit)?,
    text: @Composable (() -> Unit)?,
    shape: Shape,
    backgroundColor: Color,
    contentColor: Color
)
