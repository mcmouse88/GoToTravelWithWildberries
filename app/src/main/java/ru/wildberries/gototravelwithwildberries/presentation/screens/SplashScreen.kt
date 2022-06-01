package ru.wildberries.gototravelwithwildberries.presentation.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.wildberries.gototravelwithwildberries.data.navigation.Screens
import ru.wildberries.gototravelwithwildberries.presentation.ui.theme.MontserratTypography
import ru.wildberries.gototravelwithwildberries.presentation.viewmodels.MainViewModel

@Composable
fun SplashScreen(navController: NavHostController, viewModel: MainViewModel) {
    var startAnimation by remember {
        mutableStateOf(false)
    }

    var progress by remember {
        mutableStateOf(0.0f)
    }

    val scope = rememberCoroutineScope()

    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 3000)
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        scope.launch {
            while (progress < 1f) {
                progress += 0.1f
                delay(400)
            }
        }
        viewModel.getAllData()
        delay(timeMillis = 4000)
        navController.navigate(Screens.Main.route)
    }
    SplashLayout(alpha = alphaAnimation.value, progress = progress)
}

@Composable
fun SplashLayout(alpha: Float, progress: Float) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .background(angledComponent())
                .alpha(alpha),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row {
                Text(
                    // TODO строковые ресурсы
                    text = "WILDBERRIES",
                    modifier = Modifier.padding(bottom = 10.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MontserratTypography.h1
                )
            }
            Row {
                Text(
                    // TODO строковые ресурсы
                    text = "TRAVELING",
                    modifier = Modifier.padding(top = 10.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MontserratTypography.h2
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
        ) {
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 40.dp)
                    .padding(start = 20.dp, end = 20.dp)
                    .height(5.dp),
                progress = progress,
                backgroundColor = Color.White,
                color = Color.Black
            )
        }
    }
}

fun angledComponent(): Brush {
    return Brush.horizontalGradient(
        // TODO Вставить ссылки из ресурсов
        colors = listOf(
            Color(0xFFCB11AB),
            Color(0xFF990099),
            Color(0xFF481173)
        ),
    )
}
