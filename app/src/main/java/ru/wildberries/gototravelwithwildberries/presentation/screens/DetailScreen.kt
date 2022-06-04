package ru.wildberries.gototravelwithwildberries.presentation.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavHostController
import ru.wildberries.gototravelwithwildberries.presentation.screens.orientation.DetailLandscape
import ru.wildberries.gototravelwithwildberries.presentation.screens.orientation.DetailPortrait
import ru.wildberries.gototravelwithwildberries.presentation.ui.theme.angledComponent
import ru.wildberries.gototravelwithwildberries.presentation.viewmodels.MainViewModel

@Composable
fun DetailScreen(
    viewModel: MainViewModel,
    navController: NavHostController,
    searchToken: String
) {
    val currentWay = viewModel.allData
        .observeAsState(listOf()).value
        .firstOrNull { it.searchToken == searchToken }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(angledComponent())
    ) {
        val configuration = LocalConfiguration.current
        if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            DetailPortrait(currentWay = currentWay, navController = navController)
        } else {
            DetailLandscape(currentWay = currentWay, navController = navController)
        }
    }
}
