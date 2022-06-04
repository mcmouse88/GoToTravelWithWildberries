package ru.wildberries.gototravelwithwildberries.presentation.itemsview

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.wildberries.gototravelwithwildberries.R
import ru.wildberries.gototravelwithwildberries.presentation.ui.theme.MontserratTypography

@Composable
fun ButtonBackView(navController: NavHostController, textStyle: TextStyle) {
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