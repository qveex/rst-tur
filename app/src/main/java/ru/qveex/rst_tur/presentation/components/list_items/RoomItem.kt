package ru.qveex.rst_tur.presentation.components.list_items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import ru.qveex.rst_tur.domain.models.*
import ru.qveex.rst_tur.presentation.components.AnimatedShimmer
import ru.qveex.rst_tur.utils.translateCurrency
import ru.qveex.rst_tur.utils.translateTypePrice

@Composable
fun RoomItem(room: Room) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        val painter = rememberAsyncImagePainter(room.image.sm)
        Image(
            modifier = Modifier
                .size(104.dp)
                .clip(RoundedCornerShape(size = 8.dp)),
            painter = painter,
            contentScale = ContentScale.Crop,
            contentDescription = "Room photo"
        )
        if (painter.state !is AsyncImagePainter.State.Success) {
            AnimatedShimmer { ShimmerRoomItem(brush = it) }
        } else {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "До ${room.countTourist} гостей",
                    fontSize = MaterialTheme.typography.body2.fontSize,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Text(
                    text = room.title,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Text(
                    text = "От ${room.price.factPrice}${room.price.currency.translateCurrency()} / ${room.price.typePrice.translateTypePrice()}",
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
        }
    }
}

@Composable
fun ShimmerRoomItem(brush: Brush) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Spacer(
            modifier = Modifier
                .clip(RoundedCornerShape(size = 10.dp))
                .size(104.dp)
                .background(brush)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
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
}

@Preview
@Composable
fun RoomItemPreview() {
    RoomItem(
        room = Room(
            id = 0,
            url = null,
            image = Image(sm = "https://cdn2.rsttur.ru/photos/area-346-360-240-80.webp?v=1623070563", md = "", lg = ""),
            title = "Отель \"Океан\"",
            location = null,
            subtitle = null,
            date = Date(typeDate = "date"),
            duration = Duration(night = 1),
            price = Price(factPrice = 2500, price = 2500, discount = null, currency = "RUB", typePrice = "night"),
            countTourist = 2,
            type = "номер"
        )
    )
}