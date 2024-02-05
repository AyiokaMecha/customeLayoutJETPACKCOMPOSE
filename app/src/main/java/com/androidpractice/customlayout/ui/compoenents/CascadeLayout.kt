package com.androidpractice.customlayout.ui.compoenents

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout


@Composable

fun CascadeLayout(
    modifier: Modifier = Modifier,
    spacing: Int = 0,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        var indent = 0
        layout(constraints.maxWidth, constraints.maxHeight) {
            var yCoord = 0
            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }
            placeables.forEach { placeable ->
                placeable.placeRelative(x = indent, y = yCoord)
                indent += placeable.width + spacing
                yCoord += placeable.height + spacing
            }
        }

    }
}

//The one above is a custom layout while this one is a customLayoutModifier

fun Modifier.cascadeLayout(
    x: Int,
    y: Int
) = layout {measurable, constraints ->
    var placeable = measurable.measure(constraints)

    layout(placeable.width, placeable.height) {
        placeable.placeRelative(x, y)
    }

}