package ru.wildberries.gototravelwithwildberries.domain.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ru.wildberries.gototravelwithwildberries.R
import java.text.NumberFormat
import java.util.*

@Composable
fun formatNumberForPrice(value: Int): String {
    val numberFormat = NumberFormat.getInstance(Locale("ru", "RU"))
    return String.format(stringResource(id = R.string.price), numberFormat.format(value))
}