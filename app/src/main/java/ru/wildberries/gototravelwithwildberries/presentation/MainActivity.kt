package ru.wildberries.gototravelwithwildberries.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import ru.wildberries.gototravelwithwildberries.presentation.ui.theme.GoToTravelWithWildberriesTheme
import ru.wildberries.gototravelwithwildberries.presentation.viewmodels.MainViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoToTravelWithWildberriesTheme {
                val mainViewModel = hiltViewModel<MainViewModel>()
                mainViewModel.getAllData()
            }
        }
    }
}