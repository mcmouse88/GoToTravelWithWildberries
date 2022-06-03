package ru.wildberries.gototravelwithwildberries.presentation.screens.orientation

import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.wildberries.gototravelwithwildberries.R
import ru.wildberries.gototravelwithwildberries.domain.pojo.Data
import ru.wildberries.gototravelwithwildberries.domain.utils.differenceDate
import ru.wildberries.gototravelwithwildberries.domain.utils.formatNumberForPrice
import ru.wildberries.gototravelwithwildberries.domain.utils.parsingDate
import ru.wildberries.gototravelwithwildberries.domain.utils.parsingTime
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = currentWay?.let { parsingDate(it.startDate) } ?: "",
                        style = MontserratTypography.h6
                    )
                    Text(
                        text = currentWay?.let { parsingDate(it.endDate) } ?: "",
                        style = MontserratTypography.h6
                    )
                }

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = currentWay?.let { parsingTime(it.startDate) } ?: "",
                        fontWeight = FontWeight.Bold,
                        style = MontserratTypography.h3
                    )

                    currentWay?.let {
                        Text(
                            text = differenceDate(
                                startDate = currentWay.startDate,
                                endDate = currentWay.endDate
                            ), style = MontserratTypography.h6
                        )
                    }
                    Text(
                        text = currentWay?.let { parsingTime(it.endDate) } ?: "",
                        fontWeight = FontWeight.Bold,
                        style = MontserratTypography.h3
                    )


                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = currentWay?.startCity ?: "",
                        style = MontserratTypography.h6
                    )
                    Text(
                        text = currentWay?.endCity ?: "",
                        style = MontserratTypography.h6
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.1f)
                    .fillMaxHeight()
            ) {
                val path = PathEffect.dashPathEffect(floatArrayOf(50f, 50f), 0f)
                Canvas(modifier = Modifier
                    .fillMaxSize()
                    .height(1.dp)) {
                    drawLine(
                        start = Offset(x = 50f, y = 0f),
                        end = Offset(x = 50f, y = size.height),
                        color = Color.Gray,
                        pathEffect = path,
                        strokeWidth = 5f
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.total_price),
                        style = MontserratTypography.h6
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = currentWay?.let { formatNumberForPrice(it.price) } ?: "",
                        style = MontserratTypography.h4,
                        fontWeight = FontWeight.Bold
                    )
                    currentWay?.isLike?.let {
                        var isLikeStatus by remember {
                            mutableStateOf(currentWay.isLike)
                        }
                        Icon(
                            modifier = Modifier
                                .size(40.dp)
                                .padding(start = 10.dp)
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
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .padding(start = 10.dp, end = 20.dp)
                        .padding(top = 10.dp)
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
                            style = MontserratTypography.h6,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}
