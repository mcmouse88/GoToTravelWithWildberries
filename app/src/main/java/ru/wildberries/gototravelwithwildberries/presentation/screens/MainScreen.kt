package ru.wildberries.gototravelwithwildberries.presentation.screens

import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.wildberries.gototravelwithwildberries.data.navigation.Screens
import ru.wildberries.gototravelwithwildberries.presentation.screens.orientation.MainScreenLandscape
import ru.wildberries.gototravelwithwildberries.presentation.screens.orientation.MainScreenPortrait
import ru.wildberries.gototravelwithwildberries.presentation.ui.theme.angledComponent
import ru.wildberries.gototravelwithwildberries.presentation.viewmodels.MainViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(navController: NavHostController, viewModel: MainViewModel) {
    val allData = viewModel.allData.observeAsState(listOf()).value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(angledComponent())
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(20.dp)
                .background(angledComponent())
        ) {
            items(allData) { item ->
                Card(
                    elevation = 4.dp,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            navController.navigate(Screens.Detail.route + "/${item.searchToken}")
                        }
                ) {
                    val configuration = LocalConfiguration.current
                    if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                        MainScreenPortrait(item = item)
                    } else {
                        MainScreenLandscape(item = item)
                    }
                }
            }
        }
    }
}