package ru.qveex.rst_tur.presentation.components.lists

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.dp
import ru.qveex.rst_tur.R
import ru.qveex.rst_tur.domain.models.Fun
import ru.qveex.rst_tur.presentation.components.list_items.FunItem


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FunList(funs: List<Fun>) {

    val list = remember { mutableStateListOf<Fun>().apply { addAll(funs) } }
    var expendedState by rememberSaveable { mutableStateOf(false) }

    Column {
        Row(
            modifier = Modifier
                .padding(vertical = 14.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimatedVisibility(visible = list.isNotEmpty()) {
                Text(
                    text = stringResource(R.string.entertainment),
                    fontSize = MaterialTheme.typography.h5.fontSize
                )
                if (!expendedState) {
                    Text(
                        modifier = Modifier
                            .padding(end = 15.dp)
                            .clickable {
                                expendedState = !expendedState
                            },
                        text = stringResource(R.string.all, funs.size),
                        fontSize = MaterialTheme.typography.subtitle1.fontSize,
                        color = Color.Blue
                    )
                }
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(items = list, key = { it.id }) { f ->
                        Row(
                            Modifier
                                .animateItemPlacement(animationSpec = tween(600))
                                .fillMaxWidth()) {
                            FunItem(`fun` = f) { list.remove(f) }
                        }

                    }
                }
            }
        }
    }
}