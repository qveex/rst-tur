package ru.qveex.rst_tur.presentation.components.lists

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.qveex.rst_tur.domain.models.Fun
import ru.qveex.rst_tur.presentation.components.RoundedButton
import ru.qveex.rst_tur.presentation.components.list_items.FoodItem

@Composable
fun FoodList(foods: List<Fun>) {
    Column (modifier = Modifier.padding(15.dp)) {
        Text(
            modifier = Modifier.padding(vertical = 14.dp),
            text = "Питание",
            fontSize = MaterialTheme.typography.h5.fontSize
        )
        LazyVerticalGrid(
            modifier = Modifier.heightIn(min = 0.dp, max = 1000.dp),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(foods) { food ->
                FoodItem(food)
            }
        }
        Box(modifier = Modifier.padding(vertical = 20.dp)) {
            RoundedButton(
                isDarkTheme = false,
                text = "Показать все (${foods.size})",
                onClick = { }
            )
        }
    }
}