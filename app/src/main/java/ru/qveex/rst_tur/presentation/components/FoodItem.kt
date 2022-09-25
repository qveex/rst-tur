package ru.qveex.rst_tur.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ru.qveex.rst_tur.domain.models.Fun

@Composable
fun FoodItem(food: Fun) {
    Column (
        modifier = Modifier
            .fillMaxWidth(),
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
    }
}
