package ru.qveex.rst_tur.presentation.components

import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

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