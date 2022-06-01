package ru.wildberries.gototravelwithwildberries.domain.utils

import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter

fun parsingDate(date: String): String {
    val localDateTime = parsingDateTime(date)
    val outFormatter = DateTimeFormatter.ofPattern("dd")
    return "${outFormatter.format(localDateTime)} ${getMonth(localDateTime)}, ${getDayOfWeek(localDateTime)}"
}

fun parsingTime(date: String): String {
    val localTime = parsingDateTime(date)
    val outFormatter = DateTimeFormatter.ofPattern("HH:mm")
    return outFormatter.format(localTime)
}

private fun parsingDateTime(date: String): LocalDateTime {
    val inFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
    return LocalDateTime.parse(date, inFormatter)
}

private fun getDayOfWeek(localDateTime: LocalDateTime): String {
    // TODO throw exception
    return when (localDateTime.dayOfWeek) {
        DayOfWeek.MONDAY -> "Пн"
        DayOfWeek.TUESDAY -> "Вт"
        DayOfWeek.WEDNESDAY -> "Ср"
        DayOfWeek.THURSDAY -> "Чт"
        DayOfWeek.FRIDAY -> "Пт"
        DayOfWeek.SATURDAY -> "Сб"
        DayOfWeek.SUNDAY -> "Вс"
        null -> ""
    }
}

private fun getMonth(localDateTime: LocalDateTime): String {
    // TODO throw exception
    return when (localDateTime.month) {
        Month.JANUARY -> "Января"
        Month.FEBRUARY -> "Февраля"
        Month.MARCH -> "Марта"
        Month.APRIL -> "Апреля"
        Month.MAY -> "Мая"
        Month.JUNE -> "Июня"
        Month.JULY -> "Июля"
        Month.AUGUST -> "Августа"
        Month.SEPTEMBER -> "Сентября"
        Month.OCTOBER -> "Октября"
        Month.NOVEMBER -> "Ноября"
        Month.DECEMBER -> "Декабря"
        null -> ""
    }
}
