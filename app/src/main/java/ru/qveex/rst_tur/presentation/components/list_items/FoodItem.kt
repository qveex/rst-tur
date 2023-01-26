package ru.qveex.rst_tur.presentation.components.list_items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import ru.qveex.rst_tur.domain.models.Fun
import ru.qveex.rst_tur.presentation.components.AnimatedShimmer

@Composable
fun FoodItem(food: Fun) {
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        val painter = rememberAsyncImagePainter(food.image.sm)
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(104.dp)
                .clip(RoundedCornerShape(size = 8.dp)),
            painter = painter,
            contentScale = ContentScale.Crop,
            contentDescription = "Food photo"
        )
        /*if (painter.state !is AsyncImagePainter.State.Success) {
            Spacer(modifier = Modifier.padding(12.dp))
            AnimatedShimmer { ShimmerFoodItem(brush = it) }
        } else {*/
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = food.title,
                fontSize = MaterialTheme.typography.body1.fontSize,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = food.subtitle,
                fontSize = MaterialTheme.typography.subtitle2.fontSize,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                fontWeight = FontWeight.Normal
            )
        //}
    }
}


@Composable
fun ShimmerFoodItem(brush: Brush) {
    Column (
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(
            modifier = Modifier
                .clip(RoundedCornerShape(size = 10.dp))
                .fillMaxWidth()
                .height(104.dp)
                .background(brush)
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Spacer(
            modifier = Modifier
                .height(15.dp)
                .clip(RoundedCornerShape(size = 10.dp))
                .fillMaxWidth()
                .background(brush)
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Spacer(
            modifier = Modifier
                .height(15.dp)
                .clip(RoundedCornerShape(size = 10.dp))
                .fillMaxWidth()
                .background(brush)
        )
    }
}