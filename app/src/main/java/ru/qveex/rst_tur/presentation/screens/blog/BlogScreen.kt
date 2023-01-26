package ru.qveex.rst_tur.presentation.screens.blog

import android.graphics.Color.parseColor
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.jeziellago.compose.markdowntext.MarkdownText
import kotlinx.coroutines.delay
import ru.qveex.rst_tur.presentation.components.AnimatedShimmer
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel
import ru.qveex.rst_tur.utils.PaletteGenerator.convertImageUrlToBitmap
import ru.qveex.rst_tur.utils.PaletteGenerator.extractColorsFromBitmap
import ru.qveex.rst_tur.utils.dateConvert

@Composable
fun BlogScreen(
    sharedViewModel: SharedViewModel,
    blogViewModel: BlogViewModel = hiltViewModel(),
    blogId: Int
) {

    blogViewModel.getBlog(blogId)
    val context = LocalContext.current
    val bitmap = blogViewModel.bitmap

    if (bitmap == null) {
        AnimatedShimmer { BlogShimmer(brush = it) }
    }

    LaunchedEffect(true) {
        delay(2000)
        sharedViewModel.changeScreenTitle(blogViewModel.blog?.title ?: "")
        val bitmap_ = convertImageUrlToBitmap(
            imageUrl = blogViewModel.blog?.image?.sm ?: "https://cdn2.rsttur.ru/photos/fun-115-360-240-80.jpg?v=1623753485",
            context = context
        )
        if (bitmap_ != null) {
            blogViewModel.setBitmap(bitmap_)
            blogViewModel.setColorPalette(
                colors = extractColorsFromBitmap(
                    bitmap = bitmap_
                )
            )
        }
    }
    val colorPalette by blogViewModel.colorPalette

    if (colorPalette.isNotEmpty() && bitmap != null) {
        val vibrant by remember { mutableStateOf(colorPalette["vibrant"]!!) }
        val darkVibrant by remember { mutableStateOf(colorPalette["darkVibrant"]!!) }
        val onDarkVibrant by remember { mutableStateOf(colorPalette["onDarkVibrant"]!!) }

        val systemUiController = rememberSystemUiController()
        systemUiController.setNavigationBarColor(Color(parseColor(darkVibrant)))
        systemUiController.setStatusBarColor(Color(parseColor(vibrant)))

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            Color(parseColor(vibrant)),
                            Color(parseColor(darkVibrant))
                        )
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(256.dp)
                        .clip(RoundedCornerShape(size = 8.dp)),
                    bitmap = bitmap,
                    contentScale = ContentScale.Crop,
                    contentDescription = "Blog fun photo"
                )
                Text(
                    text = blogViewModel.blog?.date?.dateConvert() ?: "",
                    fontSize = MaterialTheme.typography.caption.fontSize,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Light,
                    color = Color(parseColor(onDarkVibrant)),
                    maxLines = 1
                )
                Text(
                    text = blogViewModel.blog?.title ?: "",
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    color = Color(parseColor(onDarkVibrant)),
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = blogViewModel.blog?.subtitle ?: "",
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    color = Color(parseColor(onDarkVibrant)),
                    fontWeight = FontWeight.Normal
                )
                MarkdownText(
                    markdown = blogViewModel.blog?.content ?: "",
                    fontSize = MaterialTheme.typography.body2.fontSize,
                    color = Color(parseColor(onDarkVibrant)),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}

@Composable
fun BlogShimmer(brush: Brush) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(256.dp)
                .clip(RoundedCornerShape(size = 8.dp))
                .background(brush),
        )
        Spacer(
            modifier = Modifier
                .height(15.dp)
                .width(100.dp)
                .clip(RoundedCornerShape(size = 10.dp))
                .background(brush)
        )
        Spacer(
            modifier = Modifier
                .height(15.dp)
                .width(150.dp)
                .clip(RoundedCornerShape(size = 10.dp))
                .background(brush)
        )
        Spacer(
            modifier = Modifier
                .height(500.dp)
                .clip(RoundedCornerShape(size = 10.dp))
                .background(brush)
                .fillMaxWidth()
        )
    }
}