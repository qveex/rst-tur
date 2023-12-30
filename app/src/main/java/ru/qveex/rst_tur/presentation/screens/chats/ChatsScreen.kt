package ru.qveex.rst_tur.presentation.screens.chats

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ru.qveex.rst_tur.R
import ru.qveex.rst_tur.navigation.Screen
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel

@Composable
fun ChatsScreen(
    sharedViewModel: SharedViewModel,
    chatsViewModel: ChatsViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) { sharedViewModel.changeScreenTitle(Screen.Chats.title) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        AsyncImage(
            modifier = Modifier
                .size(300.dp)
                .clip(RoundedCornerShape(size = 20.dp)),
            model = ImageRequest.Builder(LocalContext.current)
                .placeholder(R.drawable.ic_baseline_nights_stay)
                .data(sharedViewModel.sharedImage)
                .crossfade(enable = true)
                .build(),
            contentDescription = stringResource(R.string.picked_image_content_description),
            contentScale = ContentScale.Crop,
        )
    }
}