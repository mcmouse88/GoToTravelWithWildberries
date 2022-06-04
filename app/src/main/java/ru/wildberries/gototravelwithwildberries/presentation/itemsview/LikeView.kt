package ru.wildberries.gototravelwithwildberries.presentation.itemsview

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.wildberries.gototravelwithwildberries.R
import ru.wildberries.gototravelwithwildberries.domain.pojo.Data

@Composable
fun LikeView(item: Data?, size: Int = 30, padding: Int = 0) {
    item?.isLike?.let {
        var isLikeStatus by remember {
            mutableStateOf(item.isLike)
        }
        Icon(
            modifier = Modifier
                .size(size.dp)
                .padding(start = padding.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = false),
                ) {
                    item.isLike = !item.isLike
                    isLikeStatus = !isLikeStatus
                },
            imageVector = Icons.Default.Favorite,
            contentDescription = stringResource(id = R.string.like),
            tint = if (isLikeStatus) colorResource(id = R.color.magenta)
            else Color.Gray
        )
    }
}