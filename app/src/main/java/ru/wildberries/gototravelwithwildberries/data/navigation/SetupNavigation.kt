package ru.wildberries.gototravelwithwildberries.data.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.wildberries.gototravelwithwildberries.domain.utils.Constants.Token.DEFAULT_TOKEN
import ru.wildberries.gototravelwithwildberries.domain.utils.Constants.Token.TOKEN_KEY
import ru.wildberries.gototravelwithwildberries.presentation.screens.DetailScreen
import ru.wildberries.gototravelwithwildberries.presentation.screens.MainScreen
import ru.wildberries.gototravelwithwildberries.presentation.screens.SplashScreen
import ru.wildberries.gototravelwithwildberries.presentation.viewmodels.MainViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavigation(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ) {
        composable(route = Screens.Splash.route) {
            SplashScreen(navController = navController, viewModel = viewModel)
        }

        composable(route = Screens.Main.route) {
            MainScreen(navController = navController, viewModel = viewModel)
        }

        composable(route = Screens.Detail.route + "/{$TOKEN_KEY}") {
            DetailScreen(
                viewModel = viewModel,
                navController = navController,
                searchToken = it.arguments?.getString(TOKEN_KEY) ?: DEFAULT_TOKEN
            )
        }
    }
}