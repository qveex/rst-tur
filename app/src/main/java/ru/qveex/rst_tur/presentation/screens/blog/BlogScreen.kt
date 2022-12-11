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
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.systemuicontroller.rememberSystemUiController
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
    LaunchedEffect(true) {
        delay(2_000)
        sharedViewModel.changeScreenTitle(blogViewModel.blog.value?.title ?: "")
        val bitmap = convertImageUrlToBitmap(
            imageUrl = blogViewModel.blog.value?.image?.sm ?: "https://cdn2.rsttur.ru/photos/fun-115-360-240-80.jpg?v=1623753485",
            context = context
        )
        if (bitmap != null) {
            blogViewModel.setColorPalette(
                colors = extractColorsFromBitmap(
                    bitmap = bitmap
                )
            )
        }
    }
    val colorPalette by blogViewModel.colorPalette

    if (colorPalette.isNotEmpty()) {
        val vibrant by remember { mutableStateOf(colorPalette["vibrant"]!!) }
        val darkVibrant by remember { mutableStateOf(colorPalette["darkVibrant"]!!) }
        val onDarkVibrant by remember { mutableStateOf(colorPalette["onDarkVibrant"]!!) }

        val systemUiController = rememberSystemUiController()
        systemUiController.setNavigationBarColor(Color(parseColor(darkVibrant)))
        systemUiController.setStatusBarColor(Color(parseColor(vibrant)))

        Box(
            modifier = Modifier.background(brush = Brush.linearGradient(
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
                    .fillMaxSize()
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(256.dp)
                        .clip(RoundedCornerShape(size = 8.dp)),
                    painter = rememberAsyncImagePainter(blogViewModel.blog.value?.image?.lg),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Blog fun photo"
                )
                Text(
                    text = blogViewModel.blog.value?.date?.dateConvert() ?: "",
                    fontSize = MaterialTheme.typography.caption.fontSize,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Light,
                    color = Color(parseColor(onDarkVibrant)),
                    maxLines = 1
                )
                Text(
                    text = blogViewModel.blog.value?.title ?: "",
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    color = Color(parseColor(onDarkVibrant)),
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = blogViewModel.blog.value?.subtitle ?: "",
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    color = Color(parseColor(onDarkVibrant)),
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = blogViewModel.blog.value?.content ?: "",
                    fontSize = MaterialTheme.typography.body2.fontSize,
                    color = Color(parseColor(onDarkVibrant)),
                    fontWeight = FontWeight.Normal,
                )
            }
        }
    } else {
        AnimatedShimmer { BlogShimmer(brush = it) }
    }
}

@Composable
fun BlogShimmer(brush: Brush) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
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
                .height(2566.dp)
                .clip(RoundedCornerShape(size = 10.dp))
                .background(brush)
                .fillMaxWidth()
        )
    }
}