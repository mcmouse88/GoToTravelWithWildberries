package ru.wildberries.gototravelwithwildberries.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.wildberries.gototravelwithwildberries.R
import ru.wildberries.gototravelwithwildberries.domain.utils.formatNumberForPrice
import ru.wildberries.gototravelwithwildberries.domain.utils.parsingDate
import ru.wildberries.gototravelwithwildberries.domain.utils.parsingTime
import ru.wildberries.gototravelwithwildberries.presentation.ui.theme.MontserratTypography
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
            .padding(vertical = 24.dp, horizontal = 8.dp)
            .background(angledComponent())
    ) {
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = currentWay?.let { parsingDate(it.startDate) } ?: "",
                        style = MontserratTypography.h5,
                        color = Color.Gray
                    )
                    Text(
                        text = currentWay?.let { parsingDate(it.endDate) } ?: "",
                        style = MontserratTypography.h5,
                        color = Color.Gray
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .padding(top = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = currentWay?.let { parsingTime(it.startDate) } ?: "",
                        fontWeight = FontWeight.Bold,
                        style = MontserratTypography.h1
                    )
                    Text(
                        text = currentWay?.let { parsingTime(it.endDate) } ?: "",
                        fontWeight = FontWeight.Bold,
                        style = MontserratTypography.h1
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .padding(top = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = currentWay?.startCity ?: "",
                        style = MontserratTypography.h5
                    )
                    Text(
                        text = currentWay?.endCity ?: "",
                        style = MontserratTypography.h5
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp)
                        .padding(start = 60.dp, end = 60.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = currentWay?.let { formatNumberForPrice(it.price) } ?: "",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                    currentWay?.isLike?.let {
                        var isLikeStatus by remember {
                            mutableStateOf(currentWay.isLike)
                        }
                        Icon(
                            modifier = Modifier
                                .size(30.dp)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = rememberRipple(bounded = false),
                                ) {
                                    currentWay.isLike = !currentWay.isLike
                                    isLikeStatus = !isLikeStatus
                                },
                            imageVector = Icons.Default.Favorite,
                            contentDescription = stringResource(id = R.string.like),
                            tint = if (isLikeStatus) colorResource(id = R.color.magenta)
                            else Color.Gray
                        )
                    }
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
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(start = 10.dp, end = 10.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = stringResource(id = R.string.back),
                                tint = Color.White
                            )
                            Text(
                                text = stringResource(id = R.string.back),
                                style = MontserratTypography.h5,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}