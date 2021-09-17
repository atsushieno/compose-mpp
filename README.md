# compose-mpp

## What is this?

compose-mpp is a Kotlin Multiplatform library that fills the gap between MPP
and platform-specific Jetpack Compose + Compose for Desktop JVM libraries.
Namely, compose-mpp provides the following Compose API:

- material AlertDialog
- material DropdownMenu

## What? Isn't it already avaiable?

Short answer: no.

A bit more details: Android Jetpack Compose provides the Android implementation, and JetBrains provides the Desktop implementation. But they are incompatible. So if we'd like to write the same code in `commonMain`, we have to create by our own.

Full details: Okay, it's quite a lot of source code that you might want to skip to the next section, but anyways. Here are how `AlertDialog()` composables are defined on each platform:

<table>
<tr>
<th>[Android](https://github.com/androidx/androidx/blob/androidx-main/compose/material/material/src/androidMain/kotlin/androidx/compose/material/AndroidAlertDialog.android.kt)</th>
<th>[Desktop](https://github.com/androidx/androidx/blob/androidx-main/compose/material/material/src/desktopMain/kotlin/androidx/compose/material/DesktopAlertDialog.desktop.kt)</th>
</tr>
<tr>
<td>
```
@Composable
fun AlertDialog(
    onDismissRequest: () -> Unit,
    confirmButton: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    dismissButton: @Composable (() -> Unit)? = null,
    title: @Composable (() -> Unit)? = null,
    text: @Composable (() -> Unit)? = null,
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor),
    properties: DialogProperties = DialogProperties()
)

@Composable
fun AlertDialog(
    onDismissRequest: () -> Unit,
    buttons: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    title: (@Composable () -> Unit)? = null,
    text: @Composable (() -> Unit)? = null,
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor),
    properties: DialogProperties = DialogProperties()
)
```
</td><td>
```
@Composable
@ExperimentalMaterialApi
fun AlertDialog(
    onDismissRequest: () -> Unit,
    confirmButton: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    dismissButton: @Composable (() -> Unit)? = null,
    title: @Composable (() -> Unit)? = null,
    text: @Composable (() -> Unit)? = null,
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor),
    dialogProvider: AlertDialogProvider = PopupAlertDialogProvider
)

@Composable
@ExperimentalMaterialApi
fun AlertDialog(
    onDismissRequest: () -> Unit,
    buttons: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    title: (@Composable () -> Unit)? = null,
    text: @Composable (() -> Unit)? = null,
    shape: Shape = MaterialTheme.shapes.medium,
    backgroundColor: Color = MaterialTheme.colors.surface,
    contentColor: Color = contentColorFor(backgroundColor),
    dialogProvider: AlertDialogProvider = PopupAlertDialogProvider
)
```
</td>
</tr>
</table>

In Android version, `properties` argument is of `androidx.compose.ui.window.DialogProperties` type, which is [defined in `androidx.compose.ui.window` package](https://github.com/androidx/androidx/blob/androidx-main/compose/ui/ui/src/androidMain/kotlin/androidx/compose/ui/window/AndroidDialog.android.kt).

```
@Immutable
class DialogProperties @ExperimentalComposeUiApi constructor(
    val dismissOnBackPress: Boolean = true,
    val dismissOnClickOutside: Boolean = true,
    val securePolicy: SecureFlagPolicy = SecureFlagPolicy.Inherit,
    @Suppress("EXPERIMENTAL_ANNOTATION_ON_WRONG_TARGET")
    @get:ExperimentalComposeUiApi
    val usePlatformDefaultWidth: Boolean = true
)
```

Those `dismissOnBackPress`, `dismissOnClickOutside`, `securePolicy` properties do not make sense on Desktop. Therefore it is not even imported in its `desktopMain`.

What JetBrains uses on Desktop implementation instead is `dialogProvider` argument of `AlertDialogProvider` interface, which is its own type:

```
@ExperimentalMaterialApi
interface AlertDialogProvider {
    @Composable
    fun AlertDialog(
        onDismissRequest: () -> Unit,
        content: @Composable () -> Unit
    )
}

@ExperimentalMaterialApi
object PopupAlertDialogProvider : AlertDialogProvider {
    @Composable
    override fun AlertDialog(
        onDismissRequest: () -> Unit,
        content: @Composable () -> Unit
    ) {
        Popup(
            alignment = Alignment.Center,
            focusable = true,
            onDismissRequest = onDismissRequest,
        ) {
            Surface(elevation = 24.dp) {
                content()
            }
        }
    }
}
```

They are however the details in the optional argument for each platform.

`DropdownMenu` is under similar status, but I would not focus on it now. You can investigate it by yourselves.

Recap: we have to create by our own AlertDialog.


## Why not contribute fixes instead for Compose for Desktop?

There is [an existing GitHub issue](https://github.com/JetBrains/compose-jb/issues/762) for this.

I don't think it is fixable within Compose for Desktop.

First of all, it is not about defining a new `AlertDialog()` composable in `commonMain`. It is usually done as in `expect`/`actual` implementation switches, but Android version is not defined as such. And since Jetpack Compose (Android) API is stable, it cannot be changed. It is not defined by JetBrains anyways.

Therefore, we cannot define the *same* `AlertDialog()` composables in `commonMain`.

IF the future Kotlin compilers did not require `actual` keyword and automatically propagate references to platform specific implementation, then it might be possible to make it MPP-ready. But it's not at the moment (and I'm quite unsure if it is doable or desirable either).

It is doable in an arbitrary external Maven artifact, but not in `androidx` compose packages.


## How can we use it?

The API is so far almost identical to Jetpack Compose, except that you have to change the package in the type references in your code from `androidx.compose.material` to `dev.atsushieno.composempp.material` etc.

Here is the `build.gradle.kts` (or `build.gradle`) change to make (most likely within `kotlin { soruceSets { val commonMain by getting { dependencies { ... } } } }` section):

```
   implementation("dev.atsushieno:compose-mpp:+") // replace with specific version
```

The undocumented API reference is available at: https://atsushieno.github.io/compose-mpp/

## License

compose-mpp is available under the Apache V2 License.

