package ru.qveex.rst_tur.presentation.components.list_items

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ru.qveex.rst_tur.domain.models.Fun

@Composable
fun FunItem(`fun`: Fun, onClick: () -> Unit) {
    val maxWidth = LocalConfiguration.current.screenWidthDp
    val itemWidth = (maxWidth.dp - 50.dp) / 2
    Column(
        modifier = Modifier
            .width(itemWidth)
            .clickable { onClick() },
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(104.dp)
                .clip(RoundedCornerShape(size = 8.dp)),
            painter = rememberAsyncImagePainter(`fun`.image.sm),
            contentScale = ContentScale.Crop,
            contentDescription = "Fun photo"
        )
        Text(
            text = `fun`.title,
            fontSize = MaterialTheme.typography.body1.fontSize,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Text(
            text = `fun`.subtitle,
            fontSize = MaterialTheme.typography.body2.fontSize,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2
        )
    }
}