package ru.wildberries.gototravelwithwildberries.presentation.screens.orientation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.wildberries.gototravelwithwildberries.R
import ru.wildberries.gototravelwithwildberries.domain.pojo.Data
import ru.wildberries.gototravelwithwildberries.presentation.itemsview.*
import ru.wildberries.gototravelwithwildberries.presentation.ui.theme.MontserratTypography

@Composable
fun DetailPortrait(currentWay: Data?, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, end = 30.dp)
            .padding(top = 100.dp, bottom = 100.dp),
        elevation = 8.dp,
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            DateView(currentWay)
            TimeView(currentWay)
            CityView(currentWay)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
                    .padding(start = 60.dp, end = 60.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PriceView(item = currentWay, textStyle = MontserratTypography.h3)
                LikeView(currentWay)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                Card(
                    modifier = Modifier
                        .size(width = 120.dp, height = 40.dp)
                        .clickable { navController.popBackStack() },
                    elevation = 4.dp,
                    backgroundColor = colorResource(id = R.color.magenta)
                ) {
                    ButtonBackView(
                        navController = navController,
                        textStyle = MontserratTypography.h5
                    )
                }
            }
        }
    }
}