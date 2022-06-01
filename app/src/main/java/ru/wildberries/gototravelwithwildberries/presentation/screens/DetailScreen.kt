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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.wildberries.gototravelwithwildberries.domain.utils.formatNumberForPrice
import ru.wildberries.gototravelwithwildberries.domain.utils.parsingDate
import ru.wildberries.gototravelwithwildberries.domain.utils.parsingTime
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
                .padding(20.dp),
            elevation = 8.dp,
        ) {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = currentWay?.let { parsingDate(it.startDate) } ?: "",
                        fontSize = 16.sp
                    )
                    Text(
                        text = currentWay?.let { parsingDate(it.endDate) } ?: "",
                        fontSize = 16.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = currentWay?.let { parsingTime(it.startDate) } ?: "",
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp
                    )
                    Text(
                        text = currentWay?.let { parsingTime(it.endDate) } ?: "",
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = currentWay?.startCity ?: "",
                        fontSize = 18.sp
                    )
                    Text(
                        text = currentWay?.endCity ?: "",
                        fontSize = 18.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
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
                            contentDescription = "",
                            tint = if (isLikeStatus) Color(0xFFCB11AB) else Color.Gray
                        )
                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Card(
                        modifier = Modifier
                            .size(width = 120.dp, height = 40.dp)
                            .clickable { navController.popBackStack() },
                        elevation = 4.dp,
                        backgroundColor = Color(0xFFCB11AB)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                            Text(
                                text = "НАЗАД",
                                fontSize = 16.sp,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}