package ru.qveex.rst_tur.presentation.screens.map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ru.qveex.rst_tur.navigation.Screen
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel

@Composable
fun MapScreen(sharedViewModel: SharedViewModel) {
    sharedViewModel.changeScreenTitle(Screen.Map.title)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Map")
    }
}