package ru.wildberries.gototravelwithwildberries.domain.utils

class Constants {

    object Urls {
        const val BASE_URL = "https://travel.wildberries.ru/statistics/v1/"
        const val END_POINT = "cheap"
    }

    object ScreensRoute {
        const val SPLASH_SCREEN = "splash_screen"
        const val MAIN_SCREEN = "main_screen"
        const val DETAIL_SCREEN = "detail_screen"
    }

    object Token {
        const val TOKEN_KEY = "searchToken"
        const val DEFAULT_TOKEN = "MOW1707LED2407Y100"
    }

    object ParsingDateTime {
        const val PATTERN_INPUT_PARSING = "yyyy-MM-dd'T'HH:mm:ss'Z'"
        const val TIME_PARSING = "HH:mm"
        const val DATE_PARSING = "dd"
    }

}