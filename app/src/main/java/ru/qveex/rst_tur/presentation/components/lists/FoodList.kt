package ru.qveex.rst_tur.presentation.components.lists

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.dp
import ru.qveex.rst_tur.R
import ru.qveex.rst_tur.domain.models.Fun
import ru.qveex.rst_tur.presentation.components.RoundedButton
import ru.qveex.rst_tur.presentation.components.list_items.FoodItem

@Composable
fun FoodList(foods: List<Fun>) {
    Column (modifier = Modifier.padding(15.dp)) {

        LazyVerticalGrid(
            modifier = Modifier.heightIn(min = 0.dp, max = 1000.dp),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item(
                span = { GridItemSpan(maxCurrentLineSpan) }
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 14.dp),
                    text = stringResource(R.string.nutrition),
                    fontSize = MaterialTheme.typography.h5.fontSize
                )
            }
            items(foods) { food ->
                FoodItem(food)
            }
        }
        Box(modifier = Modifier.padding(vertical = 20.dp)) {
            RoundedButton(
                text = stringResource(R.string.show_all_food_items, foods.size),
                onClick = { }
            )
        }
    }
}


@Composable
fun FoodListFixed(
    foods: List<Fun>,
    size: Int
) {
    if (foods.size < 2) return
    Column (modifier = Modifier.padding(15.dp)) {
        Text(
            modifier = Modifier.padding(vertical = 14.dp),
            text = stringResource(id = R.string.nutrition),
            fontSize = MaterialTheme.typography.h5.fontSize
        )
        for (i in 0 until size step 2) {
            Row(modifier = Modifier.fillMaxWidth()) {
                FoodItem(food = foods[i])
                FoodItem(food = foods[i + 1])
            }
        }
        Box(modifier = Modifier.padding(vertical = 20.dp)) {
            RoundedButton(
                text = stringResource(R.string.show_all_food_items, foods.size),
                onClick = { }
            )
        }
    }
}