package ru.wildberries.gototravelwithwildberries.data.navigation

import ru.wildberries.gototravelwithwildberries.domain.utils.Constants.ScreensRoute.SPLASH_SCREEN
import ru.wildberries.gototravelwithwildberries.domain.utils.Constants.ScreensRoute.MAIN_SCREEN
import ru.wildberries.gototravelwithwildberries.domain.utils.Constants.ScreensRoute.DETAIL_SCREEN

sealed class Screens(val route: String) {

    object Splash : Screens(route = SPLASH_SCREEN)
    object Main : Screens(route = MAIN_SCREEN)
    object Detail : Screens(route = DETAIL_SCREEN)
}