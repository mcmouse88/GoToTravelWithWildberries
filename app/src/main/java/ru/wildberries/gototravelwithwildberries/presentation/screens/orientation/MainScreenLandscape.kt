package ru.wildberries.gototravelwithwildberries.presentation.screens.orientation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.wildberries.gototravelwithwildberries.R
import ru.wildberries.gototravelwithwildberries.domain.pojo.Data
import ru.wildberries.gototravelwithwildberries.domain.utils.differenceDate
import ru.wildberries.gototravelwithwildberries.domain.utils.formatNumberForPrice
import ru.wildberries.gototravelwithwildberries.domain.utils.parsingDate
import ru.wildberries.gototravelwithwildberries.domain.utils.parsingTime
import ru.wildberries.gototravelwithwildberries.presentation.ui.theme.MontserratTypography

@Composable
fun MainScreenLandscape(item: Data) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
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
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = parsingTime(item.startDate),
                    fontWeight = FontWeight.Bold,
                    style = MontserratTypography.h3
                )

                Text(
                    text = differenceDate(
                        startDate = item.startDate,
                        endDate = item.endDate
                    ), style = MontserratTypography.h6
                )
                Text(
                    text = parsingTime(item.endDate),
                    fontWeight = FontWeight.Bold,
                    style = MontserratTypography.h3
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
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
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(start = 30.dp),
            verticalArrangement = Arrangement.Center
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = formatNumberForPrice(item.price),
                    style = MontserratTypography.h4,
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
}
