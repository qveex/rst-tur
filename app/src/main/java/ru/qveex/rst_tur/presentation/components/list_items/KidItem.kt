package ru.qveex.rst_tur.presentation.components.list_items

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ru.qveex.rst_tur.domain.models.Fun

@Composable
fun KidItem(kid: Fun) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            modifier = Modifier
                .size(104.dp)
                .clip(RoundedCornerShape(size = 8.dp)),
            painter = rememberAsyncImagePainter(kid.image.sm),
            contentScale = ContentScale.Crop,
            contentDescription = "Kid fun photo"
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = kid.title,
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
            Text(
                text = kid.subtitle,
                fontSize = MaterialTheme.typography.body2.fontSize,
                overflow = TextOverflow.Ellipsis,
                maxLines = 4
            )
        }
    }
}