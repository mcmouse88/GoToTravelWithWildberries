package ru.wildberries.gototravelwithwildberries.presentation.screens.orientation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.wildberries.gototravelwithwildberries.domain.pojo.Data
import ru.wildberries.gototravelwithwildberries.presentation.itemsview.*
import ru.wildberries.gototravelwithwildberries.presentation.ui.theme.MontserratTypography

@Composable
fun MainScreenLandscape(item: Data) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            DateView(item)
            TimeView(item = item) {
                ValueInWay(item)
            }
            CityView(item)
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(start = 30.dp),
            verticalArrangement = Arrangement.Center
        ) {
            TotalPriceView()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PriceView(item = item, textStyle = MontserratTypography.h4)
                LikeView(item)
            }
        }
    }
}
