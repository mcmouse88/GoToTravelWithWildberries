package ru.wildberries.gototravelwithwildberries.presentation.screens

import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.wildberries.gototravelwithwildberries.R
import ru.wildberries.gototravelwithwildberries.data.navigation.Screens
import ru.wildberries.gototravelwithwildberries.domain.pojo.Data
import ru.wildberries.gototravelwithwildberries.domain.utils.formatNumberForPrice
import ru.wildberries.gototravelwithwildberries.domain.utils.parsingDate
import ru.wildberries.gototravelwithwildberries.domain.utils.parsingTime
import ru.wildberries.gototravelwithwildberries.presentation.screens.orientation.DetailLandscape
import ru.wildberries.gototravelwithwildberries.presentation.screens.orientation.MainScreenLandscape
import ru.wildberries.gototravelwithwildberries.presentation.ui.theme.MontserratTypography
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
                TicketItem(item = item, navController = navController)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TicketItem(item: Data, navController: NavHostController) {
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
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                        .padding(start = 10.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = parsingDate(item.startDate),
                        style = MontserratTypography.h6,
                    )

                    Text(
                        text = parsingDate(item.endDate),
                        style = MontserratTypography.h6,
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = parsingTime(item.startDate),
                        style = MontserratTypography.h3,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = parsingTime(item.endDate),
                        style = MontserratTypography.h3,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = item.startCity,
                        style = MontserratTypography.h6
                    )
                    Text(
                        text = item.endCity,
                        style = MontserratTypography.h6
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 10.dp)
                        .padding(start = 60.dp, end = 60.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = formatNumberForPrice(item.price),
                        style = MontserratTypography.h3,
                        fontWeight = FontWeight.Bold
                    )
                    var isLikeStatus by remember {
                        mutableStateOf(item.isLike)
                    }
                    Icon(
                        modifier = Modifier
                            .size(30.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = rememberRipple(bounded = false),
                            ) {
                                item.isLike = !item.isLike
                                isLikeStatus = !isLikeStatus
                            },
                        imageVector = Icons.Default.Favorite,
                        contentDescription = stringResource(id = R.string.like),
                        tint = if (isLikeStatus) colorResource(id = R.color.magenta) else Color.Gray
                    )
                }
            }

        }
        else {
            MainScreenLandscape(item = item)
        }

    }
}