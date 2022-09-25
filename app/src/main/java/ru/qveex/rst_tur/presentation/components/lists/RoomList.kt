package ru.qveex.rst_tur.presentation.components.lists

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.qveex.rst_tur.domain.models.Room
import ru.qveex.rst_tur.presentation.components.list_items.RoomItem

@Composable
fun RoomList(rooms: List<Room>) {
    LazyColumn(
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        item {
            Text(
                modifier = Modifier.padding(vertical = 14.dp),
                text = "Домики и номера",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
        items(rooms) { room ->
            RoomItem(room = room)
        }
    }
}