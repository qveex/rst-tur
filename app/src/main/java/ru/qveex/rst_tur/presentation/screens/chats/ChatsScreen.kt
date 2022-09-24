package ru.qveex.rst_tur.presentation.screens.chats

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import ru.qveex.rst_tur.navigation.Screen
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel

@Composable
fun ChatsScreen(
    sharedViewModel: SharedViewModel,
    chatsViewModel: ChatsViewModel = hiltViewModel()
) {
    sharedViewModel.changeScreenTitle(Screen.Chats.title)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Chats")
    }
}