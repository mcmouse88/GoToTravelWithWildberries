package ru.wildberries.gototravelwithwildberries.presentation.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import ru.wildberries.gototravelwithwildberries.data.navigation.Screens
import ru.wildberries.gototravelwithwildberries.domain.pojo.Data
import ru.wildberries.gototravelwithwildberries.presentation.viewmodels.MainViewModel
import ru.wildberries.gototravelwithwildberries.domain.utils.parsingDate
import ru.wildberries.gototravelwithwildberries.domain.utils.parsingTime
import ru.wildberries.gototravelwithwildberries.domain.utils.formatNumberForPrice

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
                navController.navigate(Screens.Detail.route)
            }
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = parsingDate(item.startDate),
                    fontSize = 14.sp
                )

                Text(
                    text = parsingDate(item.endDate),
                    fontSize = 14.sp
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = parsingTime(item.startDate),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = parsingTime(item.endDate),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = item.startCity,
                    fontSize = 14.sp
                )
                Text(
                    text = item.endCity,
                    fontSize = 14.sp
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = formatNumberForPrice(item.price),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                var isLikeStatus by remember {
                    mutableStateOf(item.isLike)
                }
                Icon(
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            item.isLike = !item.isLike
                            isLikeStatus = !isLikeStatus
                        },
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "",
                    tint = if (isLikeStatus) Color.Red else Color.Gray
                )
            }
        }
    }
}