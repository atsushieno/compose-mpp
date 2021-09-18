package dev.atsushieno.composempp.material

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset

@Suppress("ModifierParameter")
@Composable
internal actual fun DropdownMenuEx(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier,
    offset: DpOffset,
    properties: PopupProperties,
    content: @Composable ColumnScope.() -> Unit
) {
    androidx.compose.material.DropdownMenu(expanded, onDismissRequest, modifier, offset,
        androidx.compose.ui.window.PopupProperties(properties.focusable), content)
}
