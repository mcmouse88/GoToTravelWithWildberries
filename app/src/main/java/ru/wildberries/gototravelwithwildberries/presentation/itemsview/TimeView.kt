package ru.wildberries.gototravelwithwildberries.presentation.itemsview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.wildberries.gototravelwithwildberries.domain.pojo.Data
import ru.wildberries.gototravelwithwildberries.domain.utils.differenceDate
import ru.wildberries.gototravelwithwildberries.domain.utils.parsingTime
import ru.wildberries.gototravelwithwildberries.presentation.ui.theme.MontserratTypography

@Composable
fun TimeView(item: Data?, text: @Composable ((Data?) -> Unit)? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = item?.let { parsingTime(it.startDate) } ?: "",
            fontWeight = FontWeight.Bold,
            style = MontserratTypography.h3
        )

        if (text != null) {
            text(item)
        }

        Text(
            text = item?.let { parsingTime(it.endDate) } ?: "",
            fontWeight = FontWeight.Bold,
            style = MontserratTypography.h3
        )
    }
}

@Composable
fun ValueInWay(item: Data?) {
    item?.let {
        Text(
            text = differenceDate(
                startDate = item.startDate,
                endDate = item.endDate
            ), style = MontserratTypography.h6
        )
    }
}