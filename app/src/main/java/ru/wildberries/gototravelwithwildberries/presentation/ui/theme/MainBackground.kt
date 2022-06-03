package ru.wildberries.gototravelwithwildberries.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import ru.wildberries.gototravelwithwildberries.R

@Composable
fun angledComponent(): Brush {
    return Brush.horizontalGradient(
        colors = listOf(
            colorResource(id = R.color.magenta),
            colorResource(id = R.color.purplish),
            colorResource(id = R.color.dark_violet)
        ),
    )
}