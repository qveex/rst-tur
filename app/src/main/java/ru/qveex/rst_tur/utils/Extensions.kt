package ru.qveex.rst_tur.utils

import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

fun String.translateCurrency() = when(this) {
    "RUB" -> "₽"
    else -> ""
}

fun String.translateTypePrice() = when(this) {
    "night" -> "ночь"
    else -> ""
}

fun String.translateMonth() = when(this.substringAfter('-').substringBefore('-')) {
    "01" -> "янв"
    "02" -> "фев"
    "03" -> "март"
    "04" -> "апр"
    "05" -> "май"
    "06" -> "июнь"
    "07" -> "июль"
    "08" -> "авг"
    "09" -> "сен"
    "10" -> "окт"
    "11" -> "нояб"
    "12" -> "дек"
    else -> ""
}

fun String.dateConvert() = this.replace('-', '.').substringBefore('T')

inline fun LazyGridScope.single(crossinline itemContent: @Composable (LazyGridItemScope.() -> Unit)) {
    item(
        span = { GridItemSpan(maxCurrentLineSpan) }
    ) {
        itemContent()
    }
}

inline fun <T> LazyGridScope.list(
    items: List<T>,
    header: String = "",
    isSingleElementInRow: Boolean = false,
    crossinline listContent: @Composable ((T) -> Unit)
) {
    if (header.isNotBlank() && items.isNotEmpty())
        single {
            Text(
                text = header,
                fontSize = MaterialTheme.typography.h5.fontSize
            )
        }
    items(
        span = if (isSingleElementInRow) {{ GridItemSpan(maxCurrentLineSpan) }} else null,
        items = items
    ) { item ->
        listContent(item)
    }
}