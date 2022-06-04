package ru.wildberries.gototravelwithwildberries.presentation.screens.orientation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wildberries.gototravelwithwildberries.domain.pojo.Data
import ru.wildberries.gototravelwithwildberries.presentation.itemsview.*
import ru.wildberries.gototravelwithwildberries.presentation.ui.theme.MontserratTypography

@Composable
fun MainScreenPortrait(item: Data) {
    Column {
        DateView(item)
        TimeView(item)
        CityView(item)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp)
                .padding(start = 60.dp, end = 60.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PriceView(item = item, textStyle = MontserratTypography.h3)
            LikeView(item)
        }
    }
}