package ru.wildberries.gototravelwithwildberries.presentation.itemsview

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.unit.dp

@Composable
fun DashedLine() {
    val path = PathEffect.dashPathEffect(floatArrayOf(50f, 50f), 0f)
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .height(1.dp)
    ) {
        drawLine(
            start = Offset(x = 50f, y = 0f),
            end = Offset(x = 50f, y = size.height),
            color = Color.Magenta,
            pathEffect = path,
            strokeWidth = 5f
        )
    }
}