package ru.qveex.rst_tur.presentation.screens.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import ru.qveex.rst_tur.navigation.Screen
import ru.qveex.rst_tur.presentation.components.CircleButton
import ru.qveex.rst_tur.presentation.screens.main.SharedViewModel

@Composable
fun ProfileScreen(
    sharedViewModel: SharedViewModel,
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) { sharedViewModel.changeScreenTitle(Screen.Profile.title) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray),
        contentAlignment = Alignment.Center,
    ) {
        CircleButton(
            text = "click",
            onClicked = { },
            gradient = Brush.linearGradient(
                listOf(
                    Color(0xffc31432),
                    Color(0xff240b36),
                )
            ),
            textColor = Color.White,
            image = Icons.Outlined.DarkMode
        )
    }
}