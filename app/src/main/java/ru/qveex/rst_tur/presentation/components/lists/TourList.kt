package ru.qveex.rst_tur.presentation.components.lists

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.dp
import ru.qveex.rst_tur.*
import ru.qveex.rst_tur.domain.models.Tour
import ru.qveex.rst_tur.presentation.components.list_items.TourItem

@Composable
fun TourList(tours: List<Tour>) {
    LazyVerticalGrid(
        modifier = Modifier
            .heightIn(min = 0.dp, max = 1000.dp)
            .padding(15.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                modifier = Modifier.padding(vertical = 14.dp),
                text = stringResource(R.string.tours),
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
        item {  }
        items(tours) { tour ->
            TourItem(tour)
        }
    }
}