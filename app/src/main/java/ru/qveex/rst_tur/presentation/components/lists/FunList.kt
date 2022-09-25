package ru.qveex.rst_tur.presentation.components.lists

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.qveex.rst_tur.domain.models.Fun
import ru.qveex.rst_tur.presentation.components.list_items.FunItem

@Composable
fun FunList(funs: List<Fun>) {
    Column(
        modifier = Modifier.padding(start = 15.dp)
    ) {
        Row() {
            Text(
                modifier = Modifier
                    .padding(vertical = 14.dp)
                    .fillMaxWidth(),
                text = "Развлечения",
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items = funs) { `fun` ->
                FunItem(`fun` = `fun`)
            }
        }
    }
}