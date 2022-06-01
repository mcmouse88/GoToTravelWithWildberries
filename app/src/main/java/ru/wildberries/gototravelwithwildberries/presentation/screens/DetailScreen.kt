package ru.wildberries.gototravelwithwildberries.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
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
    Log.d("checkWay", currentWay.toString())
    Surface(
        modifier = Modifier.fillMaxSize()
            .padding(vertical = 24.dp, horizontal = 8.dp)
    ) {

    }
}