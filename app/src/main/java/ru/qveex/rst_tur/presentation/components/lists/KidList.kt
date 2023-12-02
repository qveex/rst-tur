package ru.qveex.rst_tur.presentation.components.lists

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.dp
import ru.qveex.rst_tur.R
import ru.qveex.rst_tur.domain.models.Fun
import ru.qveex.rst_tur.presentation.components.list_items.KidItem

@Composable
fun KidList(kids: List<Fun>) {
    LazyColumn(
        modifier = Modifier.heightIn(min = 0.dp, max = 1000.dp),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item {
            Text(
                modifier = Modifier.padding(vertical = 14.dp),
                text = stringResource(R.string.for_children),
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
        items(kids) { kid ->
            KidItem(kid = kid)
        }
    }
}