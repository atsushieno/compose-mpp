package dev.atsushieno.composempp.material

import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

// https://github.com/JetBrains/compose-jb/issues/762
@Composable
expect fun AlertDialog(
    // FIXME: they are defined as nullable but they indeed aren't. See https://issuetracker.google.com/issues/194625542
    onDismissRequest: (() -> Unit)? = null,
    confirmButton: @Composable (() -> Unit)? = null,
    modifier: Modifier? = Modifier,
    dismissButton: @Composable (() -> Unit)? = null,
    title: @Composable (() -> Unit)? = null,
    text: @Composable (() -> Unit)? = null,
    shape: Shape? = MaterialTheme.shapes.medium,
    backgroundColor: Color? = MaterialTheme.colors.surface,
    contentColor: Color? = contentColorFor(backgroundColor!!)
)

@Composable
expect fun AlertDialog(
    // FIXME: they are defined as nullable but they indeed aren't. See https://issuetracker.google.com/issues/194625542
    onDismissRequest: (() -> Unit)? = null,
    buttons: @Composable (() -> Unit)? = null,
    modifier: Modifier? = Modifier,
    title: (@Composable () -> Unit)? = null,
    text: @Composable (() -> Unit)? = null,
    shape: Shape? = MaterialTheme.shapes.medium,
    backgroundColor: Color? = MaterialTheme.colors.surface,
    contentColor: Color? = contentColorFor(backgroundColor!!)
)
