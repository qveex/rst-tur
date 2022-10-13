package ru.qveex.rst_tur.presentation.components.list_items

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ru.qveex.rst_tur.domain.models.Tour

@Composable
fun TourItem(tour: Tour) {
    Column (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        val painter = rememberAsyncImagePainter(tour.image.sm)
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(104.dp)
                .clip(RoundedCornerShape(size = 8.dp)),
            painter = painter,
            contentScale = ContentScale.Crop,
            contentDescription = "Tour photo"
        )
        val duration =
            if (tour.duration.hour != null)
                "${tour.duration.hour} часа"
            else
                "${tour.duration.day} дня ${tour.duration.night} ночи"

        Text(
            text = "${tour.date.date} / $duration" ,
            fontSize = MaterialTheme.typography.subtitle2.fontSize,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            fontWeight = FontWeight.Normal
        )
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = tour.title,
            fontSize = MaterialTheme.typography.subtitle2.fontSize,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            fontWeight = FontWeight.Normal
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "${tour.price.price}",
                style = TextStyle(textDecoration = TextDecoration.LineThrough),
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = "${tour.price.price}",
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                fontWeight = FontWeight.Bold
            )
        }
    }
}