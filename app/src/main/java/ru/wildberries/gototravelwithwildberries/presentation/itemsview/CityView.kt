package ru.wildberries.gototravelwithwildberries.presentation.itemsview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wildberries.gototravelwithwildberries.domain.pojo.Data
import ru.wildberries.gototravelwithwildberries.presentation.ui.theme.MontserratTypography

@Composable
fun CityView(item: Data?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = item?.startCity ?: "",
            style = MontserratTypography.h6
        )
        Text(
            text = item?.endCity ?: "",
            style = MontserratTypography.h6
        )
    }
}