package ru.wildberries.gototravelwithwildberries.domain.utils

import java.text.NumberFormat
import java.util.*

fun formatNumberForPrice(value: Int): String {
    val numberFormat = NumberFormat.getInstance(Locale("ru", "RU"))
    return "${numberFormat.format(value)} \u20BD"
}