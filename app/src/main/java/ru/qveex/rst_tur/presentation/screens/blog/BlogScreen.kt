package ru.qveex.rst_tur.presentation.screens.blog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import ru.qveex.rst_tur.navigation.Screen
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel
import ru.qveex.rst_tur.utils.dateConvert

@Composable
fun BlogScreen(
    sharedViewModel: SharedViewModel,
    blogViewModel: BlogViewModel = hiltViewModel(),
    blogId: Int
) {
    LaunchedEffect(Unit) { sharedViewModel.changeScreenTitle(blogViewModel.blog.value?.title ?: "") }
    blogViewModel.getBlog(blogId)

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
            painter = rememberAsyncImagePainter(blogViewModel.blog.value?.image?.md),
            contentScale = ContentScale.Crop,
            contentDescription = "Blog fun photo"
        )
        Text(
            text = blogViewModel.blog.value?.date?.dateConvert() ?: "",
            fontSize = MaterialTheme.typography.caption.fontSize,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Light,
            maxLines = 1
        )
        Text(
            text = blogViewModel.blog.value?.title ?: "",
            fontSize = MaterialTheme.typography.h6.fontSize,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = blogViewModel.blog.value?.subtitle ?: "",
            fontSize = MaterialTheme.typography.body1.fontSize,
            fontWeight = FontWeight.Normal
        )
        Text(
            text = blogViewModel.blog.value?.content ?: "",
            fontSize = MaterialTheme.typography.body2.fontSize,
            fontWeight = FontWeight.Normal,
        )
    }
}