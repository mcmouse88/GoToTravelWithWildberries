package ru.wildberries.gototravelwithwildberries.domain.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ru.wildberries.gototravelwithwildberries.R
import ru.wildberries.gototravelwithwildberries.domain.utils.Constants.ParsingDateTime.DATE_PARSING
import ru.wildberries.gototravelwithwildberries.domain.utils.Constants.ParsingDateTime.PATTERN_INPUT_PARSING
import ru.wildberries.gototravelwithwildberries.domain.utils.Constants.ParsingDateTime.TIME_PARSING
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter

@Composable
fun parsingDate(date: String): String {
    val localDateTime = parsingDateTime(date)
    val outFormatter = DateTimeFormatter.ofPattern(DATE_PARSING)
    return "${outFormatter.format(localDateTime)} ${getMonth(localDateTime)}, ${
        getDayOfWeek(
            localDateTime
        )
    }"
}

fun parsingTime(date: String): String {
    val localTime = parsingDateTime(date)
    val outFormatter = DateTimeFormatter.ofPattern(TIME_PARSING)
    return outFormatter.format(localTime)
}

private fun parsingDateTime(date: String): LocalDateTime {
    val inFormatter = DateTimeFormatter.ofPattern(PATTERN_INPUT_PARSING)
    return LocalDateTime.parse(date, inFormatter)
}

@Composable
private fun getDayOfWeek(localDateTime: LocalDateTime): String {
    // TODO throw exception
    return when (localDateTime.dayOfWeek) {
        DayOfWeek.MONDAY -> stringResource(id = R.string.monday)
        DayOfWeek.TUESDAY -> stringResource(id = R.string.tuesday)
        DayOfWeek.WEDNESDAY -> stringResource(id = R.string.wednesday)
        DayOfWeek.THURSDAY -> stringResource(id = R.string.thursday)
        DayOfWeek.FRIDAY -> stringResource(id = R.string.friday)
        DayOfWeek.SATURDAY -> stringResource(id = R.string.saturday)
        DayOfWeek.SUNDAY -> stringResource(id = R.string.sunday)
        null -> ""
    }
}

@Composable
private fun getMonth(localDateTime: LocalDateTime): String {
    // TODO throw exception
    return when (localDateTime.month) {
        Month.JANUARY -> stringResource(id = R.string.january)
        Month.FEBRUARY -> stringResource(id = R.string.february)
        Month.MARCH -> stringResource(id = R.string.march)
        Month.APRIL -> stringResource(id = R.string.april)
        Month.MAY -> stringResource(id = R.string.may)
        Month.JUNE -> stringResource(id = R.string.june)
        Month.JULY -> stringResource(id = R.string.july)
        Month.AUGUST -> stringResource(id = R.string.august)
        Month.SEPTEMBER -> stringResource(id = R.string.september)
        Month.OCTOBER -> stringResource(id = R.string.october)
        Month.NOVEMBER -> stringResource(id = R.string.november)
        Month.DECEMBER -> stringResource(id = R.string.december)
        null -> ""
    }
}

@Composable
fun differenceDate(startDate: String, endDate: String): String {
    val start = parsingDateTime(date = startDate)
    val end = parsingDateTime(date = endDate)


    val duration = Duration.between(start, end);
    val days = duration.toDays()
    val hours = duration.toHours() % 24
    val minutes = duration.toMinutes() % 60

    return if (days != 0L) String.format(stringResource(
        id = R.string.in_way_with_day,
        days,
        hours,
        minutes
    ))
    else String.format(
        stringResource(id = R.string.in_way_without_day),
        hours,
        minutes
    )
}
