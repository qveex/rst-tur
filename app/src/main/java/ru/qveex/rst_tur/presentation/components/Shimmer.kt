package ru.qveex.rst_tur.presentation.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.qveex.rst_tur.presentation.components.list_items.ShimmerFoodItem

@Composable
fun AnimatedShimmer(content: @Composable (Brush) -> Unit) {

    val shimmerColors = if (MaterialTheme.colors.isLight) listOf(
        Color.LightGray.copy(alpha = 0.65f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.65f)
    ) else listOf(
        Color.LightGray.copy(alpha = 0.12f),
        Color.LightGray.copy(alpha = 0.27f),
        Color.LightGray.copy(alpha = 0.12f)
    )

    val transition = rememberInfiniteTransition()
    val translateAnim = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnim.value, y = translateAnim.value)
    )

    content(brush)
}

@Composable
fun ShimmerList() {
    LazyVerticalGrid(
        modifier = Modifier.padding(top = 14.dp, start = 14.dp, end = 14.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        shimmerList { ShimmerFoodItem(brush = it) }
    }
}

private inline fun LazyGridScope.shimmerList(
    isSingleElementInRow: Boolean = false,
    crossinline listContent: @Composable ((brush: Brush) -> Unit)
) {
    item {
        AnimatedShimmer {
            Spacer(
                modifier = Modifier
                    .height(30.dp)
                    .width(100.dp)
                    .clip(RoundedCornerShape(size = 10.dp))
                    .background(it)
            )
        }
    }
    item {  } // TODO single не работает

    items(
        span = if (isSingleElementInRow) {{ GridItemSpan(maxCurrentLineSpan) }} else null,
        items = List(6) { it }
    ) {
        AnimatedShimmer { listContent(it) }
    }
}