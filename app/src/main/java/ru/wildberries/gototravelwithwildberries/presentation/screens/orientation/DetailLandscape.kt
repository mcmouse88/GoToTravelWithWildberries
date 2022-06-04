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
fun DetailLandscape(currentWay: Data?, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, end = 30.dp)
            .padding(top = 50.dp, bottom = 50.dp),
        elevation = 8.dp,
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                DateView(currentWay)
                TimeView(item = currentWay) {
                    ValueInWay(currentWay)
                }
                CityView(currentWay)
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.1f)
                    .fillMaxHeight()
            ) {
                DashedLine()
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                TotalPriceView()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    PriceView(item = currentWay, textStyle = MontserratTypography.h4)
                    LikeView(item = currentWay, size = 40, padding = 10)
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp)
                        .padding(end = 20.dp)
                        .padding(top = 10.dp)
                        .clickable { navController.popBackStack() },
                    elevation = 4.dp,
                    backgroundColor = colorResource(id = R.color.magenta)
                ) {
                    ButtonBackView(
                        navController = navController,
                        textStyle = MontserratTypography.h6
                    )
                }
            }
        }
    }
}
