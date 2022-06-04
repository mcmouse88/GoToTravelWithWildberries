package ru.wildberries.gototravelwithwildberries.presentation.itemsview

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import ru.wildberries.gototravelwithwildberries.domain.pojo.Data
import ru.wildberries.gototravelwithwildberries.domain.utils.formatNumberForPrice

@Composable
fun PriceView(item: Data?, textStyle: TextStyle) {
    Text(
        text = item?.let { formatNumberForPrice(it.price) } ?: "",
        style = textStyle,
        fontWeight = FontWeight.Bold
    )
}