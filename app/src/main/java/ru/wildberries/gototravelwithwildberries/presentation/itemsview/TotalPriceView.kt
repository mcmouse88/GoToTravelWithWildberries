package ru.wildberries.gototravelwithwildberries.presentation.itemsview

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import ru.wildberries.gototravelwithwildberries.R
import ru.wildberries.gototravelwithwildberries.presentation.ui.theme.MontserratTypography

@Composable
fun TotalPriceView() {
    Row(
        Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.total_price),
            style = MontserratTypography.h6
        )
    }
}